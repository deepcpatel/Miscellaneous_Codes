import java.util.*;
import java.io.*;
import java.*;

abstract class Shape implements Serializable
{
	public String color;

	public String getColor()
	{
		return color;
	}

	public void setColor(String c)
	{
		color=c;
	}

};

//-----------------------------------------------------------------------

abstract class shape2D extends Shape implements Serializable
{
	public abstract  float findArea();
	public abstract float findPerimetre();
	public abstract void showDetails();

} ;

//--------------------------------------------------------------------

abstract class shape3D extends Shape implements Serializable
{
	public abstract  float findSurfaceArea();
	public abstract float findVolume();
	public abstract void showDetails();

} ;

//--------------------------------------------------------------------

class Cuboid extends shape3D  implements Serializable
{
	private float [] vertices;
	private float side1, side2, side3;

	public Cuboid(float [] v)
	{
		vertices = new float[24];

		for (int i=0; i<24; i++)
		{
			vertices[i]=v[i];
		}

		side1=(float)Math.sqrt((double)(((vertices[3]-vertices[0])* (vertices[3]-vertices[0]))+((vertices[4]-vertices[1])* (vertices[4]-vertices[1]))+((vertices[5]-vertices[2])* (vertices[5]-vertices[2]))));

		side2=(float)Math.sqrt((double)(((vertices[3]-vertices[6])* (vertices[3]-vertices[6]))+((vertices[4]-vertices[7])* (vertices[4]-vertices[7]))+((vertices[5]-vertices[8])* (vertices[5]-vertices[8]))));

		side3=(float)Math.sqrt((double)(((vertices[3]-vertices[15])* (vertices[3]-vertices[15]))+((vertices[4]-vertices[16])* (vertices[4]-vertices[16]))+((vertices[5]-vertices[17])* (vertices[5]-vertices[17]))));

	}

	public float findSurfaceArea()
	{
		float sAr;

		sAr=2*((side1*side2)+(side2*side3)+(side1*side3));

		return sAr;

	}

	public float findVolume()
	{
		float volume;

		volume = side1*side2*side3;

		return volume;
	}

	public void showDetails()
	{
		int j=0;

		System.out.print("The Co-ordinates of the Cuboid Are:-\n");
		for(int i=0 ; i<24; i++)
		{

			System.out.print("\nx"+j+1+"="+vertices[i]);
			i++;
			System.out.print("\ny"+j+1+"="+vertices[i]);
			i++;
			System.out.print("\nz"+j+1+"="+vertices[i]+"\n\n");

			j=j+1;


		}

		System.out.print("\nThe size of the Sides are:-\n");
		System.out.print("\nSide1="+side1+"\nSide 2="+side2+"\nSide 3="+side3+"\n\n");
	}
}

//--------------------------------------------------------------------

class Sphere extends shape3D  implements Serializable
{
	private float[] centre;
	private float radius;

	public Sphere(float[]c, float r)
	{
		centre = new float[3];

		for(int i=0;i<3;i++)
		{
			centre[i]=c[i];
		}

		radius=r;

	}

	public float findSurfaceArea()
	{
		float sAr;

		float pi=(float)(22/7);

		sAr=(4*pi*radius*radius);

		return sAr;
	}

	public float findVolume()
	{
		float volume;

		float pi=(float)(22/7);

		volume=((4*pi*radius*radius*radius)/3);

		return volume;
	}

	public void showDetails()
	{
		System.out.print("The Co-ordinates of the Centre of the Circle are:-\n");
		System.out .print("x="+centre[0]+"\ny="+centre[1]+"\nz="+centre[2]+"\n\n");
		System.out.print("\nRadius="+radius);
	}

}

//--------------------------------------------------------------------

class Rectangle extends shape2D  implements Serializable
{
	private float [] vertices;
	private float side1, side2;

	public Rectangle(float [] v)
	{
		vertices = new float[8];

		for (int i=0; i<8; i++)
		{
			vertices[i]=v[i];
		}

		side1=(float)Math.sqrt((double)(((vertices[2]-vertices[0])* (vertices[2]-vertices[0]))+((vertices[3]-vertices[1])* (vertices[3]-vertices[1]))));

		side2=(float)Math.sqrt((double)(((vertices[2]-vertices[4])* (vertices[2]-vertices[4]))+((vertices[3]-vertices[5])* (vertices[3]-vertices[5]))));


	}

	public float findArea()
	{
		float area;

		area=side1*side2;

		return area;
	}

	public float findPerimetre()
	{
		float perimetre;

		perimetre=2*(side1+side2);

		return perimetre;
	}

	public void showDetails()
	{
		int j=0;

		System.out.print("The Co-ordinates of the Rectangle Are:-\n");
		for(int i=0 ; i<8; i++)
		{
			System.out.print("\nx"+j+1+"="+vertices[i]);
			i++;
			System.out.print("\ny"+j+1+"="+vertices[i]+"\n\n");

			j=j+1;
		}

		System.out.print("\nThe size of the Sides are:-\n");
		System.out.print("\nSide1="+side1+"\nSide 2="+side2+"\n\n");

	}

};

//--------------------------------------------------------------------

class Circle extends shape2D  implements Serializable
{
	private float[] centre;
	private float radius;

	public Circle(float[]c, float r)
	{
		centre = new float[2];

		for(int i=0;i<2;i++)
		{
			centre[i]=c[i];
		}

		radius=r;

	}

	public float  findArea()
	{
		float area;
		float pi=(float)(22/7);

		area = pi*radius*radius;

		return area;
	}


	public float findPerimetre()
	{
		float perimetre;
		float pi=(float)(22/7);

		perimetre=2*pi*radius;

		return perimetre;
	}

	public void showDetails()
	{
		System.out.print("The Co-ordinates of the Centre of the Circle are:-\n");
		System.out .print("x="+centre[0]+"\ny="+centre[1]+"\n\n");
		System.out.print("\nRadius="+radius);

	}
};

//--------------------------------------------------------------------

class main09
{
	public static void main(String[] arg) throws Exception
	{

		Scanner x = new Scanner(System.in);

		int input,ans=1,i,id,id1;
		float side[], vert[],r;
		String colour;

		Shape s;

		p:
		do
		{
            try
            {
                FileReader fr =new FileReader("id.bin");

                i=fr.read();

                fr.close();

            }

			catch(Exception e)
            {
                File dir =new File("Shapes");
                dir.mkdirs();

                FileWriter fw = new FileWriter("id.bin");

                fw.write(0);

                fw.close();

                continue p;
            }

			System.out.print("\nEnter from Below:-");
			System.out.print("\n1).Create the New 3D Shape");
			System.out.print("\n2).Create the New 2D Shape");
			System.out.print("\n3).View The Shape");
			System.out.print("\n4).Delete the Shape");
			System.out.print("\n5).Exit");
			System.out.print("\nEnter:");
			input=x.nextInt();

			switch(input)
			{
				case 1:System.out.print("\nEnter from Below:-");
                       System.out.print("\n1).Create Cuboid");
                       System.out.print("\n2).Create Sphere");
                       System.out.print("\n3).Exit");
                       System.out.print("\nEnter:");
                       input = x.nextInt();

                       if(input==1)
                       {
                                FileReader fr =new FileReader("id.bin");
                                i=fr.read();

                                vert = new float[24];
                                int j=0;
                                System.out.print("\nEnter the Vertices:-");
                                for(int k=0;k<24;k++)
                                {

                                    System.out.print("\nEnter x"+(j+1)+"=");
                                    vert[k]=(float)x.nextDouble();
                                    k++;
                                    System.out.print("\nEnter y"+(j+1)+"=");
                                    vert[k]=(float)x.nextDouble();
                                    k++;
                                    System.out.print("\nEnter z"+(j+1)+"=");
                                    vert[k]=(float)x.nextDouble();

                                    j=j+1;
                                }

                                System.out.print("\nEnter the Colour of the Shape:-");

                                colour=x.next();

                                s = new Cuboid(vert);
                                s.setColor(colour);

                                id=i;

                                FileOutputStream fout = new FileOutputStream("Shapes/"+id+".bin");
                                ObjectOutputStream oOut = new ObjectOutputStream(fout);

                                System.out.print("\nYour Shape ID is:"+id+"\n");

                                oOut.writeObject(s);
                                oOut.close();

                                i=i+1;

                                fout.close();

                                FileWriter fw1= new FileWriter("id.bin");

                                fw1.write(i);

                                fw1.close();

                                System.out.print("\nShape Created...\n\n");


                            }
                            else if(input==2)
                            {
                                FileReader fr =new FileReader("id.bin");
                                i=fr.read();

                                vert = new float[3];

                                System.out.print("\nEnter the Centre:-");

                                System.out.print("\nEnter x=");
                                vert[0]=(float)x.nextDouble();

                                System.out.print("\nEnter y=");
                                vert[1]=(float)x.nextDouble();

                                System.out.print("\nEnter z=");
                                vert[2]=(float)x.nextDouble();

                                System.out.print("\nEnter the Radius:");
                                r=(float)x.nextDouble();

                                System.out.print("\nEnter the Colour of the Shape:-");

                                colour=x.next();

                                s = new Sphere(vert,r);
                                s.setColor(colour);

                                id=i;

                                FileOutputStream fout = new FileOutputStream("Shapes/"+id+".bin");
                                ObjectOutputStream oOut = new ObjectOutputStream(fout);

                                System.out.print("\nYour Shape ID is:"+id+"\n");

                                oOut.writeObject(s);
                                oOut.close();

                                i=i+1;

                                fout.close();

                                FileWriter fw1= new FileWriter("id.bin");

                                fw1.write(i);

                                fw1.close();

                                System.out.print("\nShape Created...\n\n");

                            }
                            else
                            {
                                continue p;
                            }

                        continue p;

                case 2:System.out.print("\nEnter from Below:-");
                       System.out.print("\n1).Create Rectangle");
                       System.out.print("\n2).Create Circle");
                       System.out.print("\n3).Exit");
                       System.out.print("\nEnter:");
                       input = x.nextInt();

                       if(input==1)
                       {
                                FileReader fr =new FileReader("id.bin");
                                i=fr.read();

                                vert = new float[8];
                                int j=0;
                                System.out.print("\nEnter the Vertices:-");
                                for(int k=0;k<8;k++)
                                {

                                    System.out.print("\nEnter x"+(j+1)+"=");
                                    vert[k]=(float)x.nextDouble();
                                    k++;
                                    System.out.print("\nEnter y"+(j+1)+"=");
                                    vert[k]=(float)x.nextDouble();

                                    j=j+1;
                                }

                                System.out.print("\nEnter the Colour of the Shape:-");

                                colour=x.next();

                                s = new Rectangle(vert);
                                s.setColor(colour);

                                id=i;

                                FileOutputStream fout = new FileOutputStream("Shapes/"+id+".bin");
                                ObjectOutputStream oOut = new ObjectOutputStream(fout);

                                System.out.print("\nYour Shape ID is:"+id+"\n");

                                oOut.writeObject(s);
                                oOut.close();

                                i=i+1;

                                fout.close();

                                FileWriter fw1= new FileWriter("id.bin");

                                fw1.write(i);

                                fw1.close();

                                System.out.print("\nShape Created...\n\n");


                            }
                            else if(input==2)
                            {
                                FileReader fr =new FileReader("id.bin");
                                i=fr.read();

                                vert = new float[2];
                                int j=0;
                                System.out.print("\nEnter the Centre:-");

                                System.out.print("\nEnter x=");
                                vert[0]=(float)x.nextDouble();

                                System.out.print("\nEnter y=");
                                vert[1]=(float)x.nextDouble();

                                System.out.print("\nEnter the Radius:");
                                r=(float)x.nextDouble();

                                System.out.print("\nEnter the Colour of the Shape:-");

                                colour=x.next();

                                s = new Circle(vert,r);
                                s.setColor(colour);

                                id=i;

                                FileOutputStream fout = new FileOutputStream("Shapes/"+id+".bin");
                                ObjectOutputStream oOut = new ObjectOutputStream(fout);

                                System.out.print("\nYour Shape ID is:"+id+"\n");

                                oOut.writeObject(s);
                                oOut.close();

                                i=i+1;

                                fout.close();

                                FileWriter fw1= new FileWriter("id.bin");

                                fw1.write(i);

                                fw1.close();

                                System.out.print("\nShape Created...\n\n");

                            }
                            else
                            {
                                continue p;
                            }
                            continue p;

                case 3: String path;
                        System.out.print("\nEnter the Shape ID:");
                        id1=x.nextInt();

                        path="Shapes/"+id1+".bin";

                        File f = new File(path);

                        if(!f.exists())
                        {
                            System.out.print("\nSorry the Shape does Not exists...\n\n");
                            continue p;
                        }

                        FileInputStream fin = new FileInputStream(path);
                        ObjectInputStream oOut1 = new ObjectInputStream(fin);

                         s=(Shape)oOut1.readObject();

                        if(s instanceof Rectangle==true)
                        {

                            System.out.print("\nThe Area of the Rectangle is:"+((Rectangle)s).findArea());
                            System.out.print("\nThe Perimetre of the Rectangle is:"+((Rectangle)s).findPerimetre());
                            System.out.print("\nThe Other Details of the Rectangle is:-\n");
                            ((Rectangle)s).showDetails();

                            System.out.print("\nThe Colour of the Shape is:"+s.getColor()+"\n");
                            oOut1.close();
                        }

                        else if(s instanceof Circle==true)
                        {
                            System.out.print("\nThe Area of the Circle is:"+((Circle)s).findArea());
                            System.out.print("\nThe Perimetre of the Circle is:"+((Circle)s).findPerimetre());
                            System.out.print("\nThe Other Details of the Circle is:-");
                            ((Circle)s).showDetails();

                            System.out.print("\nThe Colour of the Shape is:"+s.getColor()+"\n");

                            oOut1.close();
                        }

                        else if(s instanceof Cuboid==true)
                        {

                            System.out.print("\nThe Surface Area of the Cuboid is:"+((Cuboid)s).findSurfaceArea());
                            System.out.print("\nThe Volume of the Cuboid is:"+((Cuboid)s).findVolume());
                            System.out.print("\nThe Other Details of the Cuboid is:-\n");
                            ((Cuboid)s).showDetails();

                            System.out.print("\nThe Colour of the Shape is:"+s.getColor()+"\n");

                            oOut1.close();
                        }

                        else
                        {

                            System.out.print("\nThe Surface Area of the Cuboid is:"+((Sphere)s).findSurfaceArea());
                            System.out.print("\nThe Volume of the Cuboid is:"+((Sphere)s).findVolume());
                            System.out.print("\nThe Other Details of the Cuboid is:-\n");
                            ((Sphere)s).showDetails();

                            System.out.print("\nThe Colour of the Shape is:"+s.getColor()+"\n");

                            oOut1.close();
                        }


                        continue p;


                case 4: String path1;
                        System.out.print("\nEnter the Shape ID to be Deleted:");
                        id1=x.nextInt();

                        path1="Shapes/"+id1+".bin";

                        File f1 = new File(path1);
                        f1.delete();

                        System.out.print("\nShape is Deleted...\n\n");

                        continue p;


                default:ans=2;
                        continue p;
			}


		}while(ans==1);

	}
};
