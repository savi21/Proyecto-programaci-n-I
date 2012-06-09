package controlador;

import javax.swing.JProgressBar;

public class HiloBarrap extends Thread {
    JProgressBar progreso;

    public HiloBarrap(JProgressBar progreso1)
    {
        super();
        this.progreso=progreso1;
    }
    @Override
public void run()
{
    for(int i=1;i<=100;i++)
    {
        progreso.setValue(i);
        pausa(86);
    }
}
public void pausa(int mlSeg)
{
    try
    {
    	Thread.sleep(mlSeg);
    }catch(Exception e){}
}
}
