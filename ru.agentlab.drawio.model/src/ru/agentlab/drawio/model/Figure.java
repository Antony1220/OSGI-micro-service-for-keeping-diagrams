/**
 *
 */
package ru.agentlab.drawio.model;

/**
 *
 * Instance if this class represents figure. Each figure has x, y coordinates, width and height.
 *
 * @author Butchenko
 *
 */
public class Figure {

	private static final String DEFAULT_TYPE = "Rectangle";

	private int id;
	private int x;
	private int y;
	private int width;
	private int height;
	private String type;

	/**
	 * Default constructor.
	 */
	public Figure() {
		type = DEFAULT_TYPE;
	}

	/**
	 *
	 * Constructor.
	 *
	 * @param type - figure type. Can't be <code>null</code>.
	 */
	public Figure(String type) {
		this.type = type;
	}

	/**
	 *
	 * Copies data from other figure.
	 *
	 * @param otherFigure - figure to copy from. Can't be <code>null</code>.
	 */
	public void copyLayoutData(Figure otherFigure) {
		setX(otherFigure.getX());
		setY(otherFigure.getY());
		setWidth(otherFigure.getWidth());
		setHeight(otherFigure.getHeight());
	}

	/**
	 * @return the x coordinate.
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y coordinate.
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return the width.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return the height.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return the type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param x - the x coordinate to set.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y - the y coordinate to set.
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @param width - the width to set.
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @param height - the height to set.
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public int hashCode() {
		return 31 * 17 + id;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		if (other == this) {
			return true;
		}

		return (other instanceof Figure) && (((Figure)other).getId() == this.getId());
	}
}
