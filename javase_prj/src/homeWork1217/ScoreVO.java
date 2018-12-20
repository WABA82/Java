package homeWork1217;

public class ScoreVO {

	private String name;
	private int javaScore, oracleScore;

	public ScoreVO(String name, int javaScore, int oracleScore) {
		this.name = name;
		this.javaScore = javaScore;
		this.oracleScore = oracleScore;
	}

	public String getName() {
		return name;
	}

	public int getJavaScore() {
		return javaScore;
	}

	public int getOracleScore() {
		return oracleScore;
	}

}
