import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Animation {
	
	private static Task<Void> sleeper;
	
	private static Thread ts;
	
	static {
//		synchronized(sleeper) {
			sleeper = new Task<Void>() {
	            @Override
	            protected Void call() throws Exception {
	                try {
	                    Thread.sleep(1000);
	                } catch (InterruptedException e) {
	                }
	                return null;
	            }
	        };
//		}
        
//        ts = ;
        
	}
	
	public static void highlightNode(Rectangle rect) {
		sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
            	rect.setFill(Color.RED);
            }
        });
		new Thread(sleeper).start();
	}

}
