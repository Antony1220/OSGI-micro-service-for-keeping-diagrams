/**
 *
 */
package ru.agentlab.drawio.ds.host;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Iterator;

import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;

import ru.agentlab.drawio.IDrawIoService;
import ru.agentlab.drawio.model.Figure;

/**
 *
 * Oomph component realisation.
 *
 * @author Butchenko
 *
 */
@Component(enabled = true, immediate = true,
    property = { "service.exported.interfaces=*", "service.exported.configs=ecf.jaxrs.jersey.server",
        "ecf.jaxrs.jersey.server.urlContext=http://localhost:8080", "ecf.jaxrs.jersey.server.alias=/drawio",
        "service.pid=ru.agentlab.drawio.ds.host.DrawIoComponent" })
public class DrawIoComponent
    implements IDrawIoService, ManagedService {

    private Collection<Figure> figures;

    @Override
    public String hello() {
        return "Hello from DrawIo";
    }

    @Override
    public String add(Figure figure) {
        if (figures.contains(figure))
        {
            return "Given figure already on diagram";
        }
        else if (figures.add(figure))
        {
            return "Figure added";
        }
        else
        {
            return "Figure wasn't added";
        }
    }

    @Override
    public String update(Figure figure) {
        Iterator<Figure> figuresIterator = figures.iterator();
        while (figuresIterator.hasNext())
        {
            Figure diagramFigure = figuresIterator.next();
            if (diagramFigure.equals(figure))
            {
                diagramFigure.copyLayoutData(figure);

                return "Figure updated";
            }
        }

        return "Diagram doesn't contain given figure";
    }

    @Override
    public String remove(Figure figure) {
        if (figures.remove(figure))
        {
            return "Figure removed";
        }
        else
        {
            if (figures.contains(figure))
            {
                return "Error. Figure wasn't removed";
            }
            else
            {
                return "Diagram doesn't contain given figure";
            }
        }
    }

    @Override
    public Collection<Figure> getFigures() {
        return figures;
    }

    @Activate
    public void activate(ComponentContext context) throws IOException {
        figures = new ArrayList<>();
        System.out.println("DrawIo service started"); //$NON-NLS-1$
    }

    @Deactivate
    public void deactivate(ComponentContext context) {
        System.out.println("DrawIo service stopped"); //$NON-NLS-1$
    }

    @Modified
    public void modify() {
        System.out.println("DrawIo service modified"); //$NON-NLS-1$
    }

    @Override
    public void updated(Dictionary<String, ?> properties) throws ConfigurationException {
        // Does nothing
    }

}
