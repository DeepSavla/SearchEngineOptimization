package AntColonyOptimization;

public class Route {
	public int RoutId;
	public double[] elements;
	public double AntScore;
	public double[] DiceCoefficient;
	public double ClusterAntScore;
	
	
	public double getAntScore() {
		return AntScore;
	}

	public void setAntScore(double antScore) {
		AntScore = antScore;
	}



	public Route(double[] elements, double AntScore , int RoutId,double[] DiceCoefficient,double ClusterAntScore) {
		this.elements = elements;
		this.AntScore = AntScore;
		this.RoutId = RoutId;
		this.DiceCoefficient = DiceCoefficient;
		this.ClusterAntScore = ClusterAntScore;
	}

	public double getClusterAntScore() {
		return ClusterAntScore;
	}

	public void setClusterAntScore(double clusterAntScore) {
		ClusterAntScore = clusterAntScore;
	}

	public int getRoutId() {
		return RoutId;
	}

	public void setRoutId(int routId) {
		RoutId = routId;
	}

	public double[] getElements() {
		return elements;
	}

	public void setElements(double[] elements) {
		this.elements = elements;
	}

	public double[] getDiceCoefficient() {
		return DiceCoefficient;
	}

	public void setDiceCoefficient(double[] diceCoefficient) {
		DiceCoefficient = diceCoefficient;
	}
	
}
