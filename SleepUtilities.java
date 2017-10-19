class SleepUtilities
{
    private static final int NAP_TIME = 5;

    public static final void nap()
    {
        SleepUtilities.nap(NAP_TIME);
    }

    public static final void nap(final int duration)
    {
        int sleeptime = (int) ( NAP_TIME * Math.random() );

        try
        {
            Thread.sleep(sleeptime * 1000);
        }
        catch ( final InterruptedException e )
        {
            // ...
        }
    }
}
