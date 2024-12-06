package Factorian;

public class Fact {
	int fact(int n ){
	      if(n==1 || n==0) return 1 ; 
	      int ok = 1 ; 
	      for(int i = 2 ;i<=n;i++){
	        ok*=i;
	      }
	      return ok ; 
	    }
	   boolean tt (int nn){
	      int sum = 0 ; 
	      int temp = nn ; 
	      while(nn>0){
	        int rem = nn%10 ; 
	        sum+=fact(rem); 
	        nn/=10 ; 
	      }
	      return sum==temp; 
	    } 
}
