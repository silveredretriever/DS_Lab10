import java.lang.Comparable;
import java.util.function.Consumer;


/**
   This is a smart Node that utilizes generics.
   Note how we ensured that the type T will always be comparable...

 */
public class BSTNode<T extends Comparable<T>>
{

   private T val;
   private BSTNode<T> left;
   private BSTNode<T> right;



   public BSTNode(T val)
   {
      this(val,null,null);
   }
    

   public BSTNode(T val, BSTNode<T> l, BSTNode<T> r)
   {
	   this.val = val;
	   this.left = l;
	   this.right = r;
   }



   /*
     Uses recursion to insert the target into the tree
    */
   public void insert(T target)
   {
	   if (target.compareTo(this.val) < 0)
	   {
		   if (this.left == null) 
		   {
			   this.left = new BSTNode<T>(target);
		   }
		   else
		   {
			   this.left.insert(target);
		   }
	   }
	   else
	   {
		   if (this.right == null) 
		   {
			   this.right = new BSTNode<T>(target);
		   }
		   else
		   {
			   this.right.insert(target);
		   }
	   }
   }


   /*
     Uses recursion to retrieved the value target from the tree.  
     Returns null if it can't find the value.
    */
   public T retrieve(T target)
   {
	   if (target.compareTo(this.val) == 0)
		{
			return target;
		}
		else if (target.compareTo(this.val) < 0) 
		{
			if (this.left == null) {
				return null;
			}
			return this.left.retrieve(target);
		}
		else 
		{
			if (this.right == null) {
				return null;
			}
			return this.right.retrieve(target);
		}
   }


    /**
       If it is present, what level is the node?
       If it is not present, what level would it be placed.
     */
   public int retrieveDepth(T target)
   {
		if (target.compareTo(this.val) == 0)
		{
			return 0;
		}
		else if (target.compareTo(this.val) < 0) 
		{
			if (this.left == null) {
				return 1;
			}
			return this.left.retrieveDepth(target) + 1;
		}
		else 
		{
			if (this.right == null) {
				return 1;
			}
			return this.right.retrieveDepth(target) + 1;
		}
   }

   /**
      Uses recursion to return the largest value in the tree
    */
   public T getLargest()
   {
		if (this.right == null)
		{
			return this.val;
		}
		return this.right.getLargest();
   }


   /**
      Uses recursion to do an inorder traversals.
      consume is part of a strategy pattern, to determine what the
      "Visit" should be.

    */
   public void inOrderTraversal(Consumer<T> consume)
   {
	   if (this.left != null)
	   {
		   this.left.inOrderTraversal(consume);
	   }
	   consume.accept(this.val);
	   if (this.right != null)
	   {
		   this.right.inOrderTraversal(consume);
	   }
   }


   /**
      returns true if this tree is equal to that tree.
      false otherwise.

      Note: While I must always be non-null.  
            Nothing prevents "that" from being null.
	    
	    This one is long!
    */
   public boolean myEquals(BSTNode<T> that)
   {
	   if (that == null || this.val != that.val)
	   {
		   return false;
	   }
	   else
	   {
		   if (this.left != null)
		   {
			   if (this.left.myEquals(that.left) == false)
			   {
				   return false;
			   }
		   }
		   else
		   {
			   if (that.left != null) 
			   {
				   return false;
			   }
		   }
		   if (this.right != null)
		   {
			   if (this.right.myEquals(that.right) == false)
			   {
				   return false;
			   }
		   }
		   else
		   {
			   if (that.right != null) 
			   {
				   return false;
			   }
		   }
		   return true;
	   }

   }

}
