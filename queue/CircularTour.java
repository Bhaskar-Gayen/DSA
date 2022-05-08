package queue;

/**
 * GFG: Circular tour Input: N = 4 Petrol = 4 6 7 4 Distance = 6 5 3 5 Output: 1
 */

public class CircularTour {

	int tour(int petrol[], int distance[]) {
		int balance = 0;
		int deficit = 0;
		int start = 0;
		for (int i = 0; i < distance.length; i++) {
			balance += petrol[i] - distance[i];
			if (balance < 0) {
				deficit += balance;
				start = i + 1;
				balance = 0;
			}
		}
		if (balance + deficit >= 0)
			return start;
		else
			return -1;
	}

}
