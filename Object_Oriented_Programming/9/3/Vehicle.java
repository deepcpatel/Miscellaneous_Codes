import java.util.*;
import java.text.*;
import java.io.*;

abstract class Vehicle implements Serializable
{
	Engine e=new Engine();
	long VehicleId;
    long milenge;
    long power;
    long torque;
    long fuel_tank_capacity;

    public Vehicle(long v,long m,long p,long t,long f,String Mileg,String Type,String Dis)
    {
		VehicleId=v;
		milenge=m;
        power=p;
        torque=t;
        fuel_tank_capacity=f;
		e.Set_Model(Mileg);
		e.Set_EnType(Type);
		e.Set_Displacement(Dis);
	}

	public void Set_milenge(long m){
		milenge=m;
	}
	public void Set_power(long p){
		power=p;
	}
	public void Set_torque(long t){
		torque=t;
	}
	public void Set_Fuel(long f){
		fuel_tank_capacity=f;
	}

	public void Set_ENMODEL(String Model)
	{
		e.Set_Model(Model);
	}
	public void Set_EnDisplacement(String Dis)
	{
		e.Set_Displacement(Dis);

	}
	public void Set_EN_TYPE(String Type)
	{
			e.Set_EnType(Type);
	}


    public void Get_VehicleDetails()
	{
		System.out.printf("\n\n");
		System.out.printf("\n MILENGE OF THIS Vehicle  :- "+milenge+" km/l");
		System.out.printf("\n POWER OF THIS Vehicle :- "+power+" rpm");
		System.out.printf("\n TORQUE OF THIS Vehicle :- "+torque+" Nm");
		System.out.printf("\n FUEL CAPACITY OF THIS Vehicle :- "+fuel_tank_capacity+" l");
		System.out.printf("\n ENGINE MODEL OF THIS Vehicle :- "+e.get_model());
		System.out.printf("\n ENGINE DISPLACEMENT OF THIS Vehicle :- "+e.get_Displacement());
		System.out.printf("\n ENGINE TYPE OF THIS Vehicle :- "+e.get_type());
	}

    public abstract void Set_TW_Cc(String C);
	public abstract String Get_TW_Cc();
	public abstract String Get_Purpose();
	public abstract String Get_Holder();
	public abstract void Set_purpose(String Pur);
	public abstract void Set_Holder(String Hol);
    public abstract void Get_AllCommercialDetails();
	public abstract String Get_Car_Type();
	public abstract void Set_Car_Type(String C_type);
}

class Engine implements Serializable
{
    private String model;
	private String Displacement;
	private String type;

	public Engine(){}

	public void Set_EngineDetails(String mod,String Ty,String Dis)
	{
		model=mod;
		Displacement=Dis;
		type=Ty;
	}

	public void Set_Model(String mod)
	{
		model=mod;
	}

	public void Set_Displacement(String Dis)
	{
		Displacement=Dis;
	}
	public void Set_EnType(String Ty)
	{
		type=Ty;
	}

	public String get_model()
	{
		return model;
	}
	public String get_Displacement()
	{
		return Displacement;
	}
	public String get_type()
	{
		return type;
	}
	/*
	public void Get_EngineDetails()
	{
		System.out.printf("\nENGINE MODEL :- "+model);
		System.out.printf("\nENGINE DISPLACEMENT :- "+Displacement);
		System.out.printf("\nENGINE TYPE :- "+type);
	}
	*/
}



abstract class FourWheeler extends Vehicle implements Serializable
{

	public FourWheeler(long v,long m, long p, long t, long f,String Mileg,String Type,String Dis)
	{
        	super(v,m, p, t, f,Mileg,Type,Dis);
    	}


	public abstract String Get_Purpose();
	public abstract String Get_Holder();
	public abstract void Set_purpose(String Pur);
	public abstract void Set_Holder(String Hol);
    public abstract void Get_AllCommercialDetails();
	public abstract String Get_Car_Type();
	public abstract void Set_Car_Type(String C_type);
}

class TwoWheeler extends Vehicle implements Serializable
{
	String Cc;
    public TwoWheeler(long v,long m, long p, long t, long f,String Mileg,String Type,String Dis,String C)
	{
        	super(v,m, p, t, f, Mileg, Type, Dis);
		Cc=C;
    }

	public void Set_TW_Cc(String C)
	{
		Cc=C;
	}

	public String Get_TW_Cc()
	{
		return Cc;
	}

	public String Get_Purpose()
	{
		System.out.printf("WRONG INPUT....SORRY");
		return "wrong";
	}
	public String Get_Holder()
	{
		System.out.printf("WRONG INPUT....SORRY");
		return "wrong";
	}

	public void Set_purpose(String Pur)
	{
		System.out.printf("WRONG INPUT....SORRY");

	}

	public void Set_Holder(String Hol){}

	 	public void Get_AllCommercialDetails(){}

	public String Get_Car_Type()
	{
		System.out.printf("WRONG INPUT....SORRY");
		return "wrong";
	}

	public void Set_Car_Type(String C_type){}
}


class Commercial extends FourWheeler implements Serializable
{

	String Purpose;
	String Holder;
    public Commercial(long v,long m, long p, long t, long f,String Mileg,String Type,String Dis,String Pur,String Hol)
	{
        super(v,m, p, t, f, Mileg, Type,Dis);
		Purpose=Pur;
		Holder=Hol;
    }

	public String Get_Purpose()
	{
		return Purpose;
	}
	public String Get_Holder()
	{
		return Holder;
	}

	public void Set_purpose(String Pur)
	{
		Purpose=Pur;
	}
	public void Set_Holder(String Hol)
	{
		Holder=Hol;
	}

    public void Get_AllCommercialDetails(){}
	public void Set_Car_Type(String C_type){}
	public void Set_TW_Cc(String C){}

	public String Get_Car_Type()
	{
		return "wrong";
	}

	public String Get_TW_Cc()
	{
		return "wrong";
	}

}


class Private extends FourWheeler implements Serializable
{
	String CarType;
	public Private(long v,long m, long p, long t, long f,String Mileg,String Type,String Dis,String C_type)
	{
        super(v,m, p, t, f, Mileg, Type, Dis);
		CarType=C_type;
    	}

	public String Get_Car_Type()
	{
		return CarType;
	}

	public void Set_Car_Type(String C_type)
	{
		CarType=C_type;
	}

	public void Set_TW_Cc(String C)
	{

	}
	public String Get_TW_Cc()
	{
		return "wrong";
	}

	public String Get_Purpose()
	{
		System.out.printf("WRONG INPUT....SORRY");
		return "wrong";
	}
	public String Get_Holder()
	{
		System.out.printf("WRONG INPUT....SORRY");
		return "wrong";
	}

	public void Set_purpose(String Pur){}
	public void Set_Holder(String Hol){}
    public void Get_AllCommercialDetails(){}

}


//MAIN CLASS


public class Vehicle
{
	public static boolean EXISTFile(String Filename)throws IOException
    	{
        	File f=new File(Filename);
        	if(f.exists())
        	{
        	    return true;
        	}
        	else
        	{
        	    return false;
        	}
    	}

	public static void DELETEFILE(String Filename)throws IOException
    	{
        	File f=new File(Filename);
        	if(f.delete())
        	{
        	    System.out.print("\n\nFILE HAS BEEN DELETED");
        	}
        	else
        	{
        	    System.out.print("\n\nERROR");
        	}
          }


	public static void MENU()
	{
			System.out.printf("\nWHICH DETAILS YOU WANT TO UPDATE? :- ");
			System.out.printf("\n1) MILENGE :- ");
			System.out.printf("\n2) POWER :- ");
			System.out.printf("\n3) TORQUE :- ");
			System.out.printf("\n4) FUEL CAPACITY :- ");
			System.out.printf("\n5) ENGINE MODEL :- ");
			System.out.printf("\n6) ENGINE DISPLACEMENT :- ");
			System.out.printf("\n7) ENGINE TYPE :- ");
	}

	public static void TodayDate()
	{
		DateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy");
		DateFormat Tateformat=new SimpleDateFormat("HH/mm/ss");
		Date date=new Date();
		System.out.println("DATE :- "+dateformat.format(date));
		System.out.println("TIME :- "+Tateformat.format(date));
	}


	public static void main(String[] args)throws IOException
	{
		Scanner x=new Scanner(System.in);
		Vehicle v;
		long VT=28561;
		long VC=16807;
		long VP=83521;
		/*
		VT=for providing different Vehicle ID for two wheeler
		VC=for providing different Vehicle ID for Commercial four Wheeler
		VP=for providing different Vehicle ID for private four Wheeler
		*/

		long Check_VID;
		/*
		Check_VID=for checking existing account
		*/
		int choice1,choice2,choice3;
		/*
		for choicing different options given here such as which Vehicle details
		you want to enter etc.
		*/
		long power_temp,milenge_temp,torque_temp,fuel_tank_capacity_temp;
		/*
		power_temp=for storing power detail of Vehicle and providing to contractor
		milenge_temp=for storing milenge detail of Vehicle and providing to contractor
		torque_temp=for stroring torque detail of Vehicle and providing to contractor
		fuel_tank_capacity_temp=for storing detail of Vehicle and providing to contractor
		*/
		String type_temp,Displacement_temp,model_temp;
		/*
		This datatype are defined for storing details of engine of Vehicle
		and providing to constractor
		*/

		System.out.printf("\n\n----------------WELCOME IN AUTOMOBILE WORLD----------------\n\n");
		TodayDate();

		while(true){

					while(true)
					{
						if(EXISTFile("Vehicle/"+VT+".txt"))
						{
							VT=VT+13;
							continue;
						}
						else
						{
							break;
						}
					}

					while(true){
						if(EXISTFile("Vehicle/"+VC+".txt"))
						{
							VC=VC+7;
							continue;
						}
						else
						{
							break;
						}
					}

					while(true){
						if(EXISTFile("Vehicle/"+VP+".txt"))
						{
							VP=VP+17;
							continue;
						}
						else
						{
							break;
						}
					}
					System.out.print("\n1) :- ADD Vehicle DETAILS");
					System.out.print("\n2) :- UPDATE Vehicle DETAILS");
					System.out.print("\n3) :- DELETE Vehicle DETAILS");
					System.out.print("\n4) :- GET DETAILS OF Vehicle");
					System.out.print("\n5) :- EXIT");
					System.out.print("\nCHOICE :- ");
					int choice=x.nextInt();
						switch(choice)
						{
							case 1:

									System.out.print("\n1) :- TWO WHEELER Vehicle ");
									System.out.print("\n2) :- FOUR WHEELER Vehicle ");
									System.out.print("\n3) :- EXIT");
									System.out.print("\nCHOICE :- ");
									choice1=x.nextInt();
									if(choice1==1)
									{

										System.out.printf("\nYOUR Vehicle ID IS "+VT+"\n\n");
										System.out.printf("\n ENTER MILENGE :- km/l.");
										milenge_temp=x.nextLong();
										System.out.printf("\n ENTER POWER :- rpm.");
										power_temp=x.nextLong();
										System.out.printf("\n ENTER TORQUE :- Nm.");
										torque_temp=x.nextLong();
										System.out.printf("\n ENTER FUEL CAPACITY :- l.");
										fuel_tank_capacity_temp=x.nextLong();
										System.out.printf("\n ENTER ENGINE MODEL :- ");
										model_temp=x.next();
										System.out.printf("\n ENTER ENGINE DISPLACEMENT :- ");
										Displacement_temp=x.next();
										System.out.printf("\n ENTER ENGINE TYPE :- ");
										type_temp=x.next();
										System.out.printf("\n ENTER Cc OF TWO WHEELER :- ");
										String C=x.next();
										try
										{

										FileOutputStream fout=new FileOutputStream("Vehicle/"+VT+".txt");
										ObjectOutputStream Oout=new ObjectOutputStream(fout);

											v=new TwoWheeler(VT,milenge_temp,power_temp,torque_temp,fuel_tank_capacity_temp,model_temp,type_temp,Displacement_temp,C);


											Oout.writeObject(v);
											Oout.flush();
											Oout.close();
											fout.close();
										}
										catch(Exception e)
										{
											System.out.printf("ERROR :- "+e);

										}

									}
									else if(choice1==2)
									{

											System.out.print("\n1) :- COMMERCIAL WHEELER Vehicle DETAILS");
											System.out.print("\n2) :- PRIVATE WHEELER Vehicle DETAILS");
											System.out.print("\n3) :- EXIT");
											System.out.print("\nCHOICE :- ");
											choice2=x.nextInt();
											if(choice2==1)
											{
												System.out.printf("\n YOUR Vehicle ID IS "+VC+"\n\n");
												System.out.printf("\n ENTER MILENGE :- ");
												milenge_temp=x.nextLong();
												System.out.printf("\n ENTER POWER :- ");
												power_temp=x.nextLong();
												System.out.printf("\n ENTER TORQUE :- ");
												torque_temp=x.nextLong();
												System.out.printf("\n ENTER FUEL CAPACITY :- ");
												fuel_tank_capacity_temp=x.nextLong();
												System.out.printf("\n ENTER ENGINE MODEL :- ");
												model_temp=x.next();
												System.out.printf("\n ENTER ENGINE DISPLACEMENT :- ");
												Displacement_temp=x.next();
												System.out.printf("\n ENTER ENGINE TYPE :- ");
												type_temp=x.next();
												System.out.printf("\n ENTER PURPOSE OF FOUR WHEELER :- ");
												String Pur=x.next();
												System.out.printf("\n ENTER HOLDER NAME OF FOUR WHEELER :- ");
												String Hol=x.next();
												try
												{

													FileOutputStream fout=new FileOutputStream("Vehicle/"+VC+".txt");
													ObjectOutputStream Oout=new ObjectOutputStream(fout);

													v=new Commercial(VC,milenge_temp,power_temp,torque_temp,fuel_tank_capacity_temp,model_temp,type_temp,Displacement_temp,Pur,Hol);


													Oout.writeObject(v);
													Oout.flush();
													Oout.close();
													fout.close();
												}
												catch(Exception e)
												{
													System.out.printf("ERROR :- "+e);

												}


											}
											else if(choice2==2)
											{
												System.out.printf("\n YOUR Vehicle ID IS "+VP+"\n\n");
												System.out.printf("\n ENTER MILENGE :- ");
												milenge_temp=x.nextLong();
												System.out.printf("\n ENTER POWER :- ");
												power_temp=x.nextLong();
												System.out.printf("\n ENTER TORQUE :- ");
												torque_temp=x.nextLong();
												System.out.printf("\n ENTER FUEL CAPACITY :- ");
												fuel_tank_capacity_temp=x.nextLong();
												System.out.printf("\n ENTER ENGINE MODEL :- ");
												model_temp=x.next();
												System.out.printf("\n ENTER ENGINE DISPLACEMENT :- ");
												Displacement_temp=x.next();
												System.out.printf("\n ENTER ENGINE TYPE :- ");
												type_temp=x.next();
												System.out.printf("\n ENTER CAR TYPE :- ");
												String C_type=x.next();

												try
												{

													FileOutputStream fout=new FileOutputStream("Vehicle/"+VP+".txt");
													ObjectOutputStream Oout=new ObjectOutputStream(fout);

													v=new Private(VP,milenge_temp,power_temp,torque_temp,fuel_tank_capacity_temp,model_temp,type_temp,Displacement_temp, C_type);


													Oout.writeObject(v);
													Oout.flush();
													Oout.close();
													fout.close();
												}
												catch(Exception e)
												{
													System.out.printf("ERROR :- "+e);

												}

											}
											else if(choice2==3)
											{
												return;
											}
											else
											{
												System.out.print("\n\nINVALID CHOICE ..");

											}


									}
									else if(choice1==3)
									{
									    	return;
									}
									else
									{
										System.out.printf("\n\nENTER INVALID CHOICE.");

									}


							break;
							case 2:
									System.out.printf("\n\nENTER Vehicle ID :- ");
									Check_VID=x.nextLong();
									if(EXISTFile("Vehicle/"+Check_VID+".txt"))
									{

											if(Check_VID%13==0)
											{
												Vehicle v1;
												FileInputStream Fin=new FileInputStream("Vehicle/"+Check_VID+".txt");
												ObjectInputStream Oin=new ObjectInputStream(Fin);

												try
												{
												v1=(TwoWheeler)Oin.readObject();
												v1.Get_VehicleDetails();
												System.out.printf("\n Cc OF THIS TWO WHEELER :- "+v1.Get_TW_Cc());

												System.out.print("\n\n");
												MENU();
												System.out.printf("\n8) Cc :- ");
												System.out.printf("\nCHOICE :- ");
												choice3=x.nextInt();

													FileOutputStream Fout1=new FileOutputStream("Vehicle/"+Check_VID+".txt");
													ObjectOutputStream Oout1=new ObjectOutputStream(Fout1);


													switch(choice3)
													{
														case 1:
															System.out.printf("\n ENTER MILENGE :- ");
															milenge_temp=x.nextLong();
															v1.Set_milenge(milenge_temp);
														break;
														case 2:
															System.out.printf("\n ENTER POWER :- ");
															power_temp=x.nextLong();
															v1.Set_power(power_temp);

														break;
														case 3:
															System.out.printf("\n ENTER TORQUE :- ");
															torque_temp=x.nextLong();
															v1.Set_torque(torque_temp);
														break;
														case 4:

															System.out.printf("\n ENTER FUEL CAPACITY :- ");
															fuel_tank_capacity_temp=x.nextLong();
															v1.Set_Fuel(fuel_tank_capacity_temp);
														break;
														case 5:
															System.out.printf("\n ENTER ENGINE MODEL :- ");
															model_temp=x.next();
															v1.Set_ENMODEL(model_temp);
														break;
														case 6:
															System.out.printf("\n ENTER ENGINE DISPLACEMENT :- ");
															Displacement_temp=x.next();
															v1.Set_EnDisplacement(Displacement_temp);
														break;
														case 7:
															System.out.printf("\n ENTER ENGINE TYPE :- ");
															type_temp=x.next();
															v1.Set_EN_TYPE(type_temp);
														break;
														case 8:
															System.out.printf("\n ENTER Cc OF TWO WHEELER :- ");
															String C=x.next();
															v1.Set_TW_Cc(C);
														break;
														default:
															System.out.printf("\nIn valid choice");

													}
													Oout1.writeObject(v1);
													Oout1.flush();
													Oout1.close();
													Fout1.close();
													Oin.close();
													Fin.close();
												}
												catch(Exception e)
												{
													System.out.printf("ERROR :- "+e);
												}

											}
											else if(Check_VID%7==0)
											{
												Vehicle v2;
												FileInputStream Fin=new FileInputStream("Vehicle/"+Check_VID+".txt");
												ObjectInputStream Oin=new ObjectInputStream(Fin);

												try
												{
													v2=(Commercial)Oin.readObject();
													v2.Get_VehicleDetails();
													System.out.printf("\n PURPOSE OF THIS FOUR WHEELER :- "+v2.Get_Purpose());
													System.out.printf("\n HOLDER OF THIS FOUR WHEELER :- "+v2.Get_Holder());

													System.out.print("\n\n");
													MENU();
													System.out.printf("\n8) CHANGE PURPOSE OF FOUR WHEELER ");
													System.out.printf("\n9) CHANGE HOLDER NAME OF FOUR WHEELER");
													System.out.printf("\nCHOICE :- ");
													choice3=x.nextInt();

													FileOutputStream Fout1=new FileOutputStream("Vehicle/"+Check_VID+".txt");
													ObjectOutputStream Oout1=new ObjectOutputStream(Fout1);


													switch(choice3)
													{
														case 1:
															System.out.printf("\n ENTER MILENGE :- ");
															milenge_temp=x.nextLong();
															v2.Set_milenge(milenge_temp);
														break;
														case 2:
															System.out.printf("\n ENTER POWER :- ");
															power_temp=x.nextLong();
															v2.Set_power(power_temp);

														break;
														case 3:
															System.out.printf("\n ENTER TORQUE :- ");
															torque_temp=x.nextLong();
															v2.Set_torque(torque_temp);
														break;
														case 4:

															System.out.printf("\n ENTER FUEL CAPACITY :- ");
															fuel_tank_capacity_temp=x.nextLong();
															v2.Set_Fuel(fuel_tank_capacity_temp);
														break;
														case 5:
															System.out.printf("\n ENTER ENGINE MODEL :- ");
															model_temp=x.next();
															v2.Set_ENMODEL(model_temp);
														break;
														case 6:
															System.out.printf("\n ENTER ENGINE DISPLACEMENT :- ");
															Displacement_temp=x.next();
															v2.Set_EnDisplacement(Displacement_temp);
														break;
														case 7:
															System.out.printf("\n ENTER ENGINE TYPE :- ");
															type_temp=x.next();
															v2.Set_EN_TYPE(type_temp);
														break;
														case 8:
															System.out.printf("\n ENTER PURPOSE OF THIS FOUR WHEELER :- ");
															String Pur=x.next();
															v2.Set_purpose(Pur);
														break;
														case 9:
															System.out.printf("\n ENTER HOLDER NAME OF THIS FOUR WHEELER :- ");
															String Hol=x.next();
															v2.Set_Holder(Hol);
														break;
														default:
															System.out.printf("\nIn valid choice");

													}
													Oout1.writeObject(v2);
													Oout1.flush();
													Oout1.close();
													Fout1.close();
													Oin.close();
													Fin.close();
												}
												catch(Exception e)
												{
													System.out.printf("ERROR :- "+e);
												}

											}
											else if(Check_VID%17==0)
											{
												Vehicle v3;
												FileInputStream Fin=new FileInputStream("Vehicle/"+Check_VID+".txt");
												ObjectInputStream Oin=new ObjectInputStream(Fin);

												try
												{
												v3=(Private)Oin.readObject();
												v3.Get_VehicleDetails();
												System.out.printf("\n TYPE OF THIS FOUR WHEELER :- "+v3.Get_Car_Type());

												System.out.print("\n\n");
												MENU();
												System.out.printf("\n8) TYPE OF THIS FOUR WHEELER :- ");
												System.out.printf("\nCHOICE :- ");
												choice3=x.nextInt();

													FileOutputStream Fout1=new FileOutputStream("Vehicle/"+Check_VID+".txt");
													ObjectOutputStream Oout1=new ObjectOutputStream(Fout1);


													switch(choice3)
													{
														case 1:
															System.out.printf("\n ENTER MILENGE :- ");
															milenge_temp=x.nextLong();
															v3.Set_milenge(milenge_temp);
														break;
														case 2:
															System.out.printf("\n ENTER POWER :- ");
															power_temp=x.nextLong();
															v3.Set_power(power_temp);

														break;
														case 3:
															System.out.printf("\n ENTER TORQUE :- ");
															torque_temp=x.nextLong();
															v3.Set_torque(torque_temp);
														break;
														case 4:

															System.out.printf("\n ENTER FUEL CAPACITY :- ");
															fuel_tank_capacity_temp=x.nextLong();
															v3.Set_Fuel(fuel_tank_capacity_temp);
														break;
														case 5:
															System.out.printf("\n ENTER ENGINE MODEL :- ");
															model_temp=x.next();
															v3.Set_ENMODEL(model_temp);
														break;
														case 6:
															System.out.printf("\n ENTER ENGINE DISPLACEMENT :- ");
															Displacement_temp=x.next();
															v3.Set_EnDisplacement(Displacement_temp);
														break;
														case 7:
															System.out.printf("\n ENTER ENGINE TYPE :- ");
															type_temp=x.next();
															v3.Set_EN_TYPE(type_temp);
														break;
														case 8:
															System.out.printf("\n ENTER TYPE OF THIS FOUR WHEELER :- ");
															String C_type=x.next();
															v3.Set_Car_Type(C_type);
														break;
														default:
															System.out.printf("\nIn valid choice");

													}
													Oout1.writeObject(v3);
													Oout1.flush();
													Oout1.close();
													Fout1.close();
													Oin.close();
													Fin.close();
												}
												catch(Exception e)
												{
													System.out.printf("ERROR :- "+e);
												}

											}
											else
											{
												System.out.printf("\n\nNO SUCH Vehicle FOUND");
											}
									}
									else
									{
										System.out.printf("\n\nNO SUCH Vehicle ID EXISTS....");
									}
							break;
							case 3:
									System.out.printf("\n\nENTER Vehicle ID :- ");
									Check_VID=x.nextLong();
									if(EXISTFile("Vehicle/"+Check_VID+".txt"))
									{
										DELETEFILE("Vehicle/"+Check_VID+".txt");
									}
									else
									{
										System.out.printf("NO SUCH Vehicle ID FIND....Sorry");
									}

							break;
							case 4:
									System.out.printf("ENTER Vehicle ID :- ");
									Check_VID=x.nextLong();
									if(EXISTFile("Vehicle/"+Check_VID+".txt"))
									{
										if(Check_VID%13==0)
										{

											try
											{
												Vehicle v1;
												FileInputStream Fin=new FileInputStream("Vehicle/"+Check_VID+".txt");
												ObjectInputStream Oin=new ObjectInputStream(Fin);

												v1=(TwoWheeler)Oin.readObject();
												v1.Get_VehicleDetails();
												System.out.printf("\n Cc OF THIS TWO WHEELER :- "+v1.Get_TW_Cc()+"\n\n");

												Oin.close();
												Fin.close();
											}
											catch(Exception e)
											{
												System.out.printf("\nERROR :- "+e+"\n\n");
											}
										}
										else if(Check_VID%7==0)
										{

											try
											{
												Vehicle v2;
												FileInputStream Fin=new FileInputStream("Vehicle/"+Check_VID+".txt");
												ObjectInputStream Oin=new ObjectInputStream(Fin);

												v2=(Commercial)Oin.readObject();
												v2.Get_VehicleDetails();
												System.out.printf("\n PURPOSE OF THIS FOUR WHEELER :- "+v2.Get_Purpose());
												System.out.printf("\n HOLDER OF THIS FOUR WHEELER :- "+v2.Get_Holder()+"\n\n");


												Oin.close();
												Fin.close();
											}
											catch(Exception e)
											{
												System.out.printf("\nERROR :- "+e+"\n\n");
											}

										}
										else if(Check_VID%17==0)
										{

											try
											{
												Vehicle v3;
												FileInputStream Fin=new FileInputStream("Vehicle/"+Check_VID+".txt");
												ObjectInputStream Oin=new ObjectInputStream(Fin);

												v3=(Private)Oin.readObject();
												v3.Get_VehicleDetails();
												System.out.printf("\n TYPE OF THIS FOUR WHEELER :- "+v3.Get_Car_Type()+"\n\n");

												Oin.close();
												Fin.close();
											}
											catch(Exception e)
											{
												System.out.printf("\n\nERROR :- "+e+"\n\n");
											}

										}
										else
										{
											System.out.printf("SORRY...NO SUCH Vehicle DETAILS ARE FOUND...\n\n");
										}

									}
									else
									{
										System.out.printf("NO SUCH Vehicle ID FIND....Sorry\n\n");
									}
							break;
							case 5:
									System.out.printf("THANKING YOU......................#SP\n\n\n");
									return;
						}

			}
	}
}
