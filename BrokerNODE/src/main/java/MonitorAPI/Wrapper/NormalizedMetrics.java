package MonitorAPI.Wrapper;

public abstract class NormalizedMetrics {

    /**
     * Gets the memory load index of the resource
     *
     * @param used
     * @param buff
     * @param cach
     * @param free
     * @return The calculated memory index of the CPU
     */
    public abstract float getICmem(float used, float buff, float cach, float free);

    /**
     * Gets the load CPU index of the resource
     *
     * @param idl
     * @return The calculated load index of the CPU
     */
    public abstract float getICcpu(float idl);

    /**
     * Gets the disk load index of the resource
     *
     * @return The calculated disk index of the CPU
     */
    public abstract float getICdsk();

    /**
     * Gets the network load index of the resource
     *
     * @return The calculated network index of the CPU
     */
    public abstract float getICnet();


}
