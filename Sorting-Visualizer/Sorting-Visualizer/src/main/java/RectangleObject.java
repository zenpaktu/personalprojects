import javafx.scene.shape.Rectangle;

public class RectangleObject {
	
	private Integer height; 
	
	private Rectangle rect;

	public RectangleObject() {
		// TODO Auto-generated constructor stub
	}
	
	public RectangleObject(Integer height) {
		this.height = height;
		rect = new Rectangle(0, 0, 20, height*10);
		// TODO Auto-generated constructor stub
	}


	public Integer getHeight() {
		return height;
	}


	public void setHeight(Integer height) {
		this.height = height;
		this.rect.setHeight(height*10);
	}


	public Rectangle getRect() {
		return rect;
	}

}
