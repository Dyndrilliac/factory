import java.security.SecureRandom;

class Producer<T> implements Runnable
{
    private Channel<T> queue;
    private SecureRandom prng;

    public Producer(final Channel<T> queue)
    {
        this.queue = queue;
        this.prng = new SecureRandom();
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

                message = this.prng.nextInt();

                if ( this.queue.send((T) message) )
                {
                    System.out.println(this.toString() + " produced " + message);
                }
                else
                {
                    System.out.println(this.toString() + " is idle; can't produce because buffer is full.");
                }
            }
            catch ( Exception e )
            {
                // ...
            }
        }
    }
}
