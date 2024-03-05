package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 수학_참외 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int fruit = Integer.parseInt(br.readLine());

		List<Integer> direction = new ArrayList<>();
		List<Integer> field = new ArrayList<>();

		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			direction.add(Integer.parseInt(st.nextToken()));
			field.add(Integer.parseInt(st.nextToken()));
		}

		while (!(direction.get(0) == direction.get(2) && direction.get(1) == direction.get(3))) {

			direction.add(direction.remove(0));
			field.add(field.remove(0));
			
		}
		
		int result = (field.get(4) * field.get(5) - (field.get(1) * field.get(2))) * fruit;
		
		System.out.println(result);
	}

}
