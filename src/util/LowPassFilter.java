package util;

/**
 * This class utilizes bilinear transformations to calculate the, what would be,
 * a more correct reading from the sensor. It also tracks the last value and the current
 * value and throws out any readings that stray too far from the expected values. 
 * 
 * Math that this is based upon:
 * y = [(x + xp) - (1 - (2tau/T))yp] / [1 + (2tau/T)]
 * 
 * where tau = 1 / f-cutoff
 * T = sample time
 */
public class LowPassFilter {
	private final double tau;
	private final double sampleTime;
    private final double maxIncrement;
    
    private double yPrevious = 0;
    private double xPrevious = 0;
    
    private double lastError = -1;

    /**
     * This class can be used to filter data through a low pass filter.
     * 
     * @param cutOffFrequency The frequency (in Hz) that should be used for cut off.
     * @param sampleTime The time (in seconds) that your data is sampled.
     * @param maxIncrement The maximum increment expected in the input in any one sample.  If the 
     * input step exceeds this maximum, the sample is not used, and the previous input sample is used
     * instead.  If the sample occurs again, then this new value is used as the new baseline.
     */
    public LowPassFilter(double cutOffFrequency, double sampleTime, double maxIncrement) {
        this.tau = 1 / cutOffFrequency;
        this.sampleTime      = sampleTime;
        this.maxIncrement    = maxIncrement;
    }

    /**
     * Reset the lowpass filter to an initial value.
     * 
     * @param initVal value to initialize the filter to.
     */
    public void reset(double initVal) {
        yPrevious = xPrevious = initVal;
    }

    /**
     * Calculates/adjusts the output given the low pass filter.
     * 
     * @param x The input to pass to the filter
     * @return The filtered output
     */
    public double calculate(double x) {
    	// Determine whether to use this sample.
        if (Math.abs(x - xPrevious) < maxIncrement || Math.abs(lastError - x) < 5) {
       	    // y = [(x + xp) - (1 - (2tau/T))yp] / [1 + (2tau/T)]
        	double numerator = (x + xPrevious) - (1 - (2 * tau / sampleTime)) * yPrevious;
            double denominator = 1 + (2 * tau / sampleTime);
            double y = numerator / denominator;

            xPrevious = x;
            yPrevious = y;
            lastError = -1;
            
            return y;
        } else {
        	lastError = x;
        }

        return yPrevious;
    }
}