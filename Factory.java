class Factory<T> implements Runnable
{
    public static final void main(final String[] args)
    {
        Thread factory = new Thread(new Factory<Integer>());
        factory.start();
    }

    @Override
    public final void run()
    {
        Thread[] producerPool = null;
        Thread[] consumerPool = null;
        // You can raise or lower the maximum buffer size with the MessageQueue constructor. The default is 15.
        Channel<T> queue = new MessageQueue<T>( /* 15 */ );

        // Play with the ratio of Producers to Consumers in order to test for interesting edge cases. I recommend 1:1, 5:5. 1:5, and 5:1.
        // Add and/or remove comments here as necessary to change the ratio settings quickly! :-)
        producerPool = new Thread[] { new Thread(new Producer<T>(queue)) };
        //producerPool = new Thread[] { new Thread(new Producer<T>(queue)), new Thread(new Producer<T>(queue)), new Thread(new Producer<T>(queue)), new Thread(new Producer<T>(queue)), new Thread(new Producer<T>(queue)) };
        //consumerPool = new Thread[] { new Thread(new Consumer<T>(queue)) };
        consumerPool = new Thread[] { new Thread(new Consumer<T>(queue)), new Thread(new Consumer<T>(queue)), new Thread(new Consumer<T>(queue)), new Thread(new Consumer<T>(queue)), new Thread(new Consumer<T>(queue)) };

        if ( producerPool != null )
        {
            for ( Thread t : producerPool )
            {
                t.start();
            }
        }

        if ( consumerPool != null )
        {
            for ( Thread t : consumerPool )
            {
                t.start();
            }
        }
    }
}
