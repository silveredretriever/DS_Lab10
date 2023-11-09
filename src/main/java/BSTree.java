import java.util.function.Consumer;
import java.util.List;
import java.util.ArrayList;


//This is a Binary Search Tree (BST) that only holds Integers
public class BSTree
{
    
   private BSTNode<Integer> root;

   public BSTree()
   {
   
       
   }

    /**
       returns true if the tree is empty
     */
   public boolean isEmpty()
   {
      return root == null;
   }


    /**
       inserts target into the tree
     */
   public void insert(Integer target)
   {
	   if (isEmpty()) {
		   root = new BSTNode<Integer>(target);
	   } else {
		   root.insert(target);
	   }
   }


    /**
       returns the Integer if it is present in the tree
       returns null if target is not in the tree.
     */
   public Integer retrieve(Integer target)
   {
	   if (isEmpty())
	   {
		   return null;
	   }
	   return root.retrieve(target);  
   }


    /**
       This is not a normal method for a tree
       It will return the height of the node that contains the target
       (note that root is 0)

       However, if the node is not present, return the height that 
       the node would be if you add it.
     */
   public int retrieveDepth(Integer target)
   {
	   if (isEmpty())
	   {
		   return 0;
	   }
	   return root.retrieveDepth(target);   
   }

    
    /**
       This is an inner class to create a consumer that will count the 
       number of nodes in the tree.
    */
   class CountConsumer implements Consumer<Integer>
   {
      public int nodes = 0;
   
      public void accept(Integer val)
      {
         nodes++;
      }
   
   }

    /**
       Already written
    */
   public int getSize()
   {
      if(root==null) 
         return 0;
   
      CountConsumer count = new CountConsumer();
      root.inOrderTraversal(count);
      return count.nodes;
   }


    /**
       Returns the largest value in the tree.

       Your solution should have average time of Theta( log N)

       return null, if the tree is empty
    */
   public Integer largest()
   {
		if (isEmpty())
		{
			return null;
		}
		return root.getLargest();
   
   }


    /**
       Returns a list of all the values in the tree.

       Instead of using an inner class, this time use an anonymous class
       Most of the code has been set up for you.
    */
   public List<Integer> toList()
   {
       
      List<Integer> L= new ArrayList<Integer>();
   
      if(root != null)
      {
         root.inOrderTraversal(
            //hey look, an anonymous class 		       
            new Consumer<Integer>() //here is the type 
            {
               public void accept(Integer i)
               {
            	   L.add(i);
               }
            });
      }
      return L;
   
   
   }




    /*
      Returns the sum of all the integers in the Tree
     */
   public int sum()
   {
	   List<Integer> L = toList();
	   int total = 0;
	   for (int i = 0; i < getSize(); i++)
	   {
		   total = total + L.get(i).intValue();
	   }
	   return total;
   }



    /**
       Returns true if this tree is equal to that tree, false otherwise.

       A tree is equal if they have not only the same stored valued
       but also the same structure.  For example, a tree with inserted
       values {5,1,10} would not be equal to a BST with inserted
       values {1,5,10}.

       Note: we didn't use equals because it is slightly more complex to get right.
     */
   public boolean myEquals(BSTree that)
   {
	   if (this.isEmpty() || that.isEmpty())
	   {
		   return this.isEmpty() == that.isEmpty();
	   }
	   return root.myEquals(that.root);
   }






}
