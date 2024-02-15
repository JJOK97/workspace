package study;

public class 일타싸피_강사님코드 {

	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;

	static final float RADIUS = 5.73f;

	// 왼쪽 아래가 (0,0), 오른쪽 위 (254, 127)
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

	public static void main(String[] args) {

		// 빗겨치기가 아니라, 중심을 맞춘다고 했을 때
		// 두 공의 좌표가 주어질 경우.
		// ball0 -> ball1을 맞추려고 할 때. 각도는?

		float[] ball0 = { 60f, 63.5f }; // (x, y좌표 순)
		float[] ball1 = { 224f, 107f };

		float dx = ball1[0] - ball0[0];
		float dy = ball1[1] - ball0[1];
		// tan(a) = dx/dy;
		// a = atan(dx/dy);

		double a = Math.atan(dx / dy);
		double b = Math.toDegrees(a);

		System.out.printf("%f, %f\n", a, b);

	}
}
