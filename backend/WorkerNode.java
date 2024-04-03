
/* 
public class WorkerNode implements Runnable {
    
    private Socket masterSocket;

    public WorkerNode(Socket masterSocket) {
        this.masterSocket = masterSocket;
    }

    @Override
    public void run() {
        try {
            // Worker logic here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private synchronized void processTask(Object task) {
        // Task processing logic
        // Use 'synchronized' to guard this critical section
    }
}
*/