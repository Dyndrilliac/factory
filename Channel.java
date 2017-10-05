interface Channel<T>
{
    public abstract T receive();

    public abstract boolean send(final T item);
}
