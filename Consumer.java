class Consumer<T> implements Runnable
{
    private Channel<T> queue;

    public Consumer(final Channel<T> queue)
    {
        this.queue = queue;
    }

    @Override
    public final void run()
    {
        T message;

        while ( !Thread.currentThread().isInterrupted() )
        {
            try
            {
                SleepUtilities.nap();

                message = this.queue.receive();

                if ( message != null )
                {
                    System.out.println("Consumer consumed " + message);
                }
                else
                {
                    System.out.println("Consumer is idle; can't consume because buffer is empty.");
                }
            }
            catch ( Exception e )
            {
                // ...
            }
        }
    }
}
