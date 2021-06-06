package main;

import java.util.Scanner;

public class APS_MAIN {

	public static void main(String[] args) {
		QueueHelper q = new QueueHelper();
		Scanner sca = new Scanner(System.in);
		boolean emer = false;
		boolean getOut = false;
		
		while(true)
		{
			if(getOut)
				break;
			System.out.println("1 - Adicionar paciente");
			System.out.println("2 - Proximo paciente");
			System.out.println("3 - Atender proximo paciente");
			System.out.println("4 - Sair");
			int input = sca.nextInt();
			switch(input)
			{
				case 1:
					System.out.println("Nome do paciente");
					String name = sca.next();
					System.out.println("Idade do paciente");
					int age = sca.nextInt();
					System.out.println("A situação do paciente é precária?");
					char emerString = sca.next().charAt(0);
					
					if(Character.toLowerCase(emerString) == 's')
						emer = true;
					
					Person n = new Person(name, age, emer);
					
					if(n.isEmergency())
						q.addEmergencyPersonQueue(n);
					else if(n.getAge() > 55)
						q.addElderPersonQueue(n);
					else
						q.addPersonQueue(n);
					
					System.out.println("Paciente cadastrado!");
					break;
				case 2:
					if(q.showNextPerson() == null)
					{
						System.out.println("Nao tem ninguem na fila");
						break;
					}
					Person p = q.showNextPerson();
					System.out.println("Paciente "+p.getName()+" eh o proximo!");
					break;
				case 3:
					if(q.showNextPerson() == null)
					{
						System.out.println("Nao tem ninguem na fila");
						break;
					}
					Person person = q.getNextPerson();
					System.out.println("Paciente "+person.getName()+" foi atendido!");
					break;
				case 4:
					getOut = true;
					break;
			}
		}
		
		sca.close();
	}
	
}
