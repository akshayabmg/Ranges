package com.akshaya.range;

public class Ranges {
	
	private int low;
	private int up;
	
	//Constructors
	Ranges(int low, int up){
		if(low <= up) {
			this.low = low;
			this.up = up;
		} else {
			this.low = up;
			this.up = low;	
		}
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public int getUp() {
		return up;
	}

	public void setup(int up) {
		this.up = up;
	}
	
	public String toString() {
		return String.format("['%d','%d']", low, up );
	}
	
	public boolean equals(Object other){
		boolean result = false;
        if (other instanceof Ranges) {
            Ranges that = (Ranges) other;
            result = (this.getLow()==that.getLow() && this.getUp() ==that.getUp() );
        }
        return result;
	}
	
	
}
