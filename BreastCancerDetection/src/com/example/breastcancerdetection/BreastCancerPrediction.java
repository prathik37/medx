package com.example.breastcancerdetection;

public class BreastCancerPrediction {
	
	public static Double[] coeff_ = { 0.14430764, -0.00814041,  
							0.14848617,  0.07680202,  0.07556753,  0.10412306,
		  					0.06776519,  0.07424853,  0.14055528};
	public static double intercept_ = -2.5419316;
	
	public static boolean predict(Double[] features)
	{
		Double pred = 0.0;
		for (int i=0; i<features.length; i++)
		{
			pred +=coeff_[i]*features[i];
		}
		pred +=intercept_;
		return pred>0;
	}
	
}
