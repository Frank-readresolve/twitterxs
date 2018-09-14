package fr.formation.twitterxs.errors;

import java.io.Serializable;

/**
 * Represents a validation error.
 */
public final class ValidationError implements Serializable {

    private static final long serialVersionUID = -3177218154124197588L;

    private String entityName;

    private String fieldName;

    private String error;

    private Type type = Type.FIELD;

    /**
     * Creates a new {@code ValidationError} with given values an default type
     * ({@code Type.FIELD}).
     *
     * @param entityName
     *            the name of the entity
     * @param fieldName
     *            the name of the field
     * @param error
     *            the error code or message
     */
    private ValidationError(String entityName, String fieldName, String error) {
	this.entityName = entityName;
	this.fieldName = fieldName;
	this.error = error;
    }

    public String getEntityName() {
	return entityName;
    }

    /**
     * Return the field name, global validator name in case of global error.
     *
     * @return the field name or global validator name
     */
    public String getFieldName() {
	return fieldName;
    }

    /**
     * Returns the error code or message.
     *
     * @return the error code or message
     */
    public String getError() {
	return error;
    }

    /**
     * Returns the type of error.
     *
     * @return the type of error
     */
    public Type getType() {
	return type;
    }

    public static ValidationError ofGlobalType(String entityName,
	    String fieldName, String errorMessage) {
	ValidationError error = new ValidationError(entityName, fieldName,
		errorMessage);
	error.type = Type.GLOBAL;
	return error;
    }

    public static ValidationError ofFieldType(String entityName,
	    String fieldName, String errorMessage) {
	return new ValidationError(entityName, fieldName, errorMessage);
    }

    /**
     * Returns a string representation of this {@code validation error}.
     *
     * @return a string representation of this {@code validation error}
     */
    @Override
    public String toString() {
	return "{entityName=" + entityName + ", fieldName=" + fieldName
		+ ", error=" + error + ", type=" + type + "}";
    }

    public static enum Type {
	FIELD, GLOBAL;
    }
}
