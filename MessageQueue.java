import java.util.concurrent.ConcurrentLinkedQueue;

class MessageQueue<T> implements Channel<T>
{
    private int                      maxBufferSize = 0;
    private ConcurrentLinkedQueue<T> queue         = null;

    public MessageQueue()
    {
        this(15);
    }

    public MessageQueue(final int maxBufferSize)
    {
        this.queue = new ConcurrentLinkedQueue<T>();
        this.setMaxBufferSize(maxBufferSize);
    }

    public final int getMaxBufferSize()
    {
        return this.maxBufferSize;
    }

    @Override
    public T receive()
    {
        if ( this.queue.isEmpty() )
        {
            return null;
        }
        else
        {
            return this.queue.poll();
        }
    }

    @Override
    public boolean send(final T item)
    {
        if ( this.queue.size() < this.getMaxBufferSize() )
        {
            this.queue.offer(item);
            return true;
        }
        else
        {
            return false;
        }
    }

    public final void setMaxBufferSize(final int maxBufferSize)
    {
        this.maxBufferSize = maxBufferSize;
    }
}
