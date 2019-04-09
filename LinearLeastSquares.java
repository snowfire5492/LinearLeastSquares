 /**
 * CS 301: Numerical Methods
 * Professor: A. Khakpour
 *
 * Computer Exercise: 9.1 # 2
 *
 * @author - Eric Schenck
 * last modified: September 27, 2017
 *   
 */
public class LinearLeastSquares {
	
	public static void main(String[] args){
		
		float[] T = {0,10,20,30,40,0,90,85};					// T coordinate (kinda like x coord)
		float[] S = {(float)68.00,(float)67.1,(float)66.4,(float)65.6,(float)64.6,(float)61.8,(float)61.0,(float)60.0};
																// S coordinate (kinda like y coord)
		float[][] linearSystem = new float[3][2];
		int n = T.length;
		float XiSquared = 0;
		float Xi = 0;
		float XiYi = 0;
		float Yi = 0;
		
		float firstMultiplier = 0;
		float secondMultiplier = 0;
		
		float a;
		float b;
	
		for(int i = 0 ; i < n; ++i){
			XiSquared += T[i] * T[i];							// calculate sum(Xi)^2				
			Xi += T[i];											// calculate sum(Xi)
			XiYi += T[i] * S[i];  								// calculate sum(XiYi)
			Yi += S[i];											// calculate sum(Yi)
		}
		float sumOne = n;										// calculate sum(1)
		
		linearSystem[0][1] = XiSquared;
		linearSystem[1][1] = Xi;
		linearSystem[2][1] = XiYi;
		linearSystem[0][0] = Xi;
		linearSystem[1][0] = sumOne;
		linearSystem[2][0] = Yi;
		
		firstMultiplier = (-1) * linearSystem[0][1];
		secondMultiplier = linearSystem[0][0];
		
		for(int i = 0; i < 3; ++i){
			linearSystem[i][0] = (firstMultiplier * linearSystem[i][1]) + (secondMultiplier * linearSystem[i][0]);
		}
		
		b = linearSystem[2][0] / linearSystem[1][0];
		
		a = linearSystem[2][1] - (linearSystem[1][1] * b );
		a /= linearSystem[0][1];
		
		
		System.out.println("y = ax + b ");
		System.out.println("y = " + a + "x + " + b);
		
	}
	
	
	

}
