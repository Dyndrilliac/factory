import java.util.Random;

class Producer<T> implements Runnable
{
    private Channel<T> queue;

    public Producer(final Channel<T> queue)
    {
        this.queue = queue;
    }

    @SuppressWarnings("unchecked")
    @Override
    public final void run()
    {
        Object message = null;

        while ( !Thread.currentThread().isInterrupted() )
        {
            try
            {
                SleepUtilities.nap();

                message = ( new Random() ).nextInt();

                if ( this.queue.send((T) message) )
                {
                    System.out.println("Producer produced " + message);
                }
                else
                {
                    System.out.println("Producer is idle; can't produce because buffer is full.");
                }
            }
            catch ( Exception e )
            {
                // ...
            }
        }
    }
}
