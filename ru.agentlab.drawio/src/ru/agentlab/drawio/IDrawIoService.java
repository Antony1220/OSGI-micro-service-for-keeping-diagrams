/**
 *
 */
package ru.agentlab.drawio;

import java.util.Collection;

import ru.agentlab.drawio.model.Figure;

/**
 *
 * DrawIo service. Stores figures.
 *
 * @author Butchenko
 *
 */
public interface IDrawIoService {

    /**
     *
     * Says hello to user.
     *
     * @return hello message. Can't return <code>null</code>.
     */
    String hello();

    /**
     *
     * Adds given figure to diagram.
     *
     * @param figure - figure to add. Can't be <code>null</code>.
     *
     * @return message to user. Can't return <code>null</code>.
     */
    String add(Figure figure);

    /**
     *
     * Updates given figure. Given figure should be on diagram.
     *
     * @param figure - figure to update. Can't be <code>null</code>.
     *
     * @return message to user. Can't return <code>null</code>.
     */
    String update(Figure figure);

    /**
     *
     * Removes given figure from diagram.
     *
     * @param figure - figure to remove. Can't be <code>null</code>.
     *
     * @return message to user. Can't return <code>null</code>.
     */
    String remove(Figure figure);

    /**
     * 
     * Returns all figures from diagram.
     *
     * @return figures from diagram. Can't return <code>null</code>.
     */
    Collection<Figure> getFigures();
}
