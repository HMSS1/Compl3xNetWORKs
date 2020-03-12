package visual;


public abstract class DecoratorScatterView extends ScatterView{
	ScatterView scatterView;
	
	public DecoratorScatterView(ScatterView scatterView){
		super(scatterView.getGraph());
		this.scatterView = scatterView;
	}


}