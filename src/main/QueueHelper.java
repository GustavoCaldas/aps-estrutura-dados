package main;

import java.util.LinkedList;
import java.util.Queue;

public class QueueHelper {
	private Queue<Person> elderQueue;
	private int auxElderQueue;
	private Queue<Person> youngerQueue;
	private Queue<Person> emergencyQueue;
	
	public QueueHelper() {
		this.elderQueue = new LinkedList<Person>();
		this.youngerQueue = new LinkedList<Person>();
		this.emergencyQueue = new LinkedList<Person>();
		this.auxElderQueue = 0;
	}
	
	public void addElderPersonQueue(Person person)
	{
		this.elderQueue.add(person);
	}
	public void addPersonQueue(Person person)
	{
		this.youngerQueue.add(person);
	}
	public void addEmergencyPersonQueue(Person person)
	{
		this.emergencyQueue.add(person);
	}
	
	public Person getNextPerson()
	{
		if(this.emergencyQueue.peek() != null)
			return this.emergencyQueue.poll();
		else if(this.auxElderQueue < 2)
		{
			this.auxElderQueue++;
			return this.elderQueue.poll();
		}
		else
			return this.youngerQueue.poll();
	}
	
	public Person showNextPerson()
	{
		if(this.emergencyQueue.peek() != null)
			return this.emergencyQueue.peek();
		else if(this.auxElderQueue < 2)
			return this.elderQueue.peek();
		else
			return this.youngerQueue.peek();
	}
}
