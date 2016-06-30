package com.nagarro.cwms.execution.model;

/**
 * Execution steps which has to be built upon using the stored values. 
 *
 * @param <T>
 */
public interface StepExecution<T> {
	
	/**
	 * Execution method which will provide implementation specific to Step type.
	 * @param context carrying the values
	 */
	void execute(ExecutionContext context);
	
	/**
	 * Method to build the object out of actual stored object.
	 * 
	 * @param t
	 * @return StepExecution
	 */
	StepExecution<T> build(T t);
}
