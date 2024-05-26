import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
public class p2 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        JFrame frame = new JFrame("BOOK STALL");
        frame.setSize(640,480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        JButton insertButton = new JButton("Insert books");
        insertButton.setBounds(210, 60, 200, 75);
        JButton searchButton = new JButton("Search books");
        searchButton.setBounds(210, 150, 200, 75);
        JButton updateButton = new JButton("Buy books");
        updateButton.setBounds(210, 240, 200, 75);
        JButton newButton = new JButton("New books");
        newButton.setBounds(210, 330, 200, 75);
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) 
            {
                JFrame insertFrame = new JFrame("Insert Window");
                JTextField atext=new JTextField(20);
                JTextField btext=new JTextField(20);
                JTextField ctext=new JTextField(20);
                JTextField dtext=new JTextField(20);
                JTextField etext=new JTextField(20);
                JTextField out=new JTextField(20);
                JButton ins=new JButton("INSERT");
                JLabel a=new JLabel("Publisher name");
                JLabel b=new JLabel("PBookID");
                JLabel c=new JLabel("Author");
                JLabel d=new JLabel("Book name");
                JLabel e=new JLabel("Copies");
                insertFrame.add(atext);
                insertFrame.add(btext);
                insertFrame.add(ctext);
                insertFrame.add(dtext);
                insertFrame.add(etext);
                insertFrame.add(ins);
                insertFrame.add(a);
                insertFrame.add(out);
                insertFrame.add(b);
                insertFrame.add(c);
                insertFrame.add(d);
                insertFrame.add(e);
                insertFrame.setLayout(null);
                ins.setBounds(260,100,110,25);
                out.setBounds(260,140,110,25);
                a.setBounds(10,40,110,25);
                b.setBounds(10,90,110,25);
                c.setBounds(10,140,110,25);
                d.setBounds(10,190,110,25);
                e.setBounds(10,240,110,25);
                atext.setBounds(140,40,110,25);
                btext.setBounds(140,90,110,25);
                ctext.setBounds(140,140,110,25);
                dtext.setBounds(140,190,110,25);
                etext.setBounds(140,240,110,25);
                insertFrame.setSize(500, 400);
                insertFrame.setVisible(true);
                ins.addActionListener(new ActionListener()
                {
                 public void actionPerformed(ActionEvent x)
                  {
                   try
                   {
                   Scanner scan=new Scanner(System.in);
                   String bid,bname,author,publisher;
                   int copy;
                   Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstall","root","2402");
                   Statement stm=con.createStatement(); 
                   publisher=atext.getText();
                   bid=btext.getText();
                   author=ctext.getText();
                   bname=dtext.getText();
                   copy=Integer.parseInt(etext.getText());
                   int rs=stm.executeUpdate("insert into publisher (bookid,name,author,publisher,copy) values('"+bid+"','"+bname+"','"+author+"','"+publisher+"',"+copy+")");
                   if(rs==1)
                   {
                   out.setText("Destination Updated");
                   }
                   else
                   {
                   out.setText("Destination not Updated");
                   }
                  stm.close();
                  con.close();  
                   }
                  catch(ClassNotFoundException e)
                  {
                  System.out.println(e);
                  }
                  catch(SQLException e)
                  {
                  System.out.println(e);
                  }               
                  }
                }); 
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) 
            {
            JFrame searchFrame = new JFrame("Search Window");
            JLabel id=new JLabel("bookid");
            JButton s=new JButton("SEARCH");
            JTextField idtext=new JTextField(20);
            JTextField atext=new JTextField(20);
            JTextField btext=new JTextField(20);
            JTextField ctext=new JTextField(20);
            JTextField dtext=new JTextField(20);
            JTextField etext=new JTextField(20);
            JTextField out=new JTextField(20);
            JLabel a=new JLabel("Publisher name");
            JLabel b=new JLabel("PBookID");
            JLabel c=new JLabel("Author");
            JLabel d=new JLabel("Book name");
            JLabel e=new JLabel("Copies");
            searchFrame.add(id);
            searchFrame.add(s);
            searchFrame.add(idtext);
            searchFrame.add(atext);
            searchFrame.add(btext);
            searchFrame.add(ctext);
            searchFrame.add(dtext);
            searchFrame.add(etext);
            searchFrame.add(out);
            searchFrame.add(a);
            searchFrame.add(b);
            searchFrame.add(c);
            searchFrame.add(d);
            searchFrame.add(e);
            searchFrame.add(out);
            searchFrame.setLayout(null);
            s.setBounds(260,100,110,25);
            id.setBounds(260,30,90,25);
            idtext.setBounds(320,30,110,25);
            out.setBounds(260,100,110,25);
            a.setBounds(10,40,110,25);
            b.setBounds(10,90,110,25);
            c.setBounds(10,140,110,25);
            d.setBounds(10,190,110,25);
            e.setBounds(10,240,110,25);
            atext.setBounds(140,40,110,25);
            btext.setBounds(140,90,110,25);
            ctext.setBounds(140,140,110,25);
            dtext.setBounds(140,190,110,25);
            etext.setBounds(140,240,110,25);
            searchFrame.setSize(500, 400);
            searchFrame.setVisible(true);
                s.addActionListener(new ActionListener()
                {
                 public void actionPerformed(ActionEvent x)
                  {
                   try
                   {
                   Scanner scan=new Scanner(System.in);
                   String bid,bname,author,publisher,val;
                   int copy,numrows;
                   numrows=0;
                   Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstall","root","2402");
                   Statement stm=con.createStatement(); 
                   val=idtext.getText();
                   String qry = "select * from publisher";
                   ResultSet rs = stm.executeQuery(qry);
                   while(rs.next())
                   {
                   bid=rs.getString(1);
                   if(bid.equals(val))
                   {
                    atext.setText(rs.getString(4));
                    btext.setText(rs.getString(1));
                    ctext.setText(rs.getString(3));
                    dtext.setText(rs.getString(2));
                    etext.setText(Integer.toString(rs.getInt(5)));
                    out.setText("Found");
                    numrows++;
                   }
                  }
                   if(numrows<1)
                    {
                     atext.setText("NULL");
                     btext.setText("NULL");
                     ctext.setText("NULL");
                     dtext.setText("NULL");
                     etext.setText("NULL");
                     out.setText("Not found");
                    }
                  }
                  catch(ClassNotFoundException e)
                  {
                  System.out.println(e);
                  }
                  catch(SQLException e)
                  {
                  System.out.println(e);
                  }                 
                  }
                }); 
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) 
            {
                JFrame updateFrame = new JFrame("Buy Window");
                JTextField cid=new JTextField(20);
JTextField cname=new JTextField(20);
JTextField phno=new JTextField(20);
JTextField bname=new JTextField(20);
JTextField qty=new JTextField(20);
JTextField price=new JTextField(20);
JTextField dop=new JTextField(20);
JTextField out=new JTextField(20);
JButton sub=new JButton("Submit");
JLabel a=new JLabel("CUSTOMER ID: ");
JLabel b=new JLabel("CUSTOMER NAME: ");
JLabel c=new JLabel("PHONE NUMBER: ");
JLabel d=new JLabel("BOOK NAME: ");
JLabel e=new JLabel("QUANTITY: ");
JLabel f=new JLabel("PRICE: ");
JLabel g=new JLabel("DATE OF PURCHASE: ");
JLabel h=new JLabel("STATUS:");
updateFrame.add(cid);
updateFrame.add(cname);
updateFrame.add(phno);
updateFrame.add(bname);
updateFrame.add(qty);
updateFrame.add(price);
updateFrame.add(dop);
updateFrame.add(sub);
updateFrame.add(out);
updateFrame.add(a);
updateFrame.add(b);
updateFrame.add(c);
updateFrame.add(d);
updateFrame.add(e);
updateFrame.add(f);
updateFrame.add(g);
updateFrame.add(h);
updateFrame.setLayout(null);
cid.setBounds(140,40,150,25);
cname.setBounds(140,70,150,25);
phno.setBounds(140,100,150,25);
bname.setBounds(140,130,150,25);
qty.setBounds(140,160,150,25);
price.setBounds(140,190,150,25);
dop.setBounds(140,220,150,25);
sub.setBounds(100,280,200,80);
out.setBounds(100,380,150,25);
a.setBounds(10,40,150,25);
b.setBounds(10,70,150,25);
c.setBounds(10,100,150,25);
d.setBounds(10,130,150,25);
e.setBounds(10,160,150,25);
f.setBounds(10,190,150,25);
g.setBounds(10,220,150,25);
h.setBounds(10,380,150,25);
updateFrame.setSize(800,800);
updateFrame.setVisible(true);
                sub.addActionListener(new ActionListener()
                {
                 public void actionPerformed(ActionEvent x)
                  {
                   try{
int cid1,qty1;
String cname1,bname1,dop1,phno1;
Double price1;
       Scanner scan=new Scanner(System.in);
        Object souce =ae.getSource();
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstall","root","2402");
Statement stm=con.createStatement();
cid1=Integer.parseInt(cid.getText());
cname1=cname.getText();
phno1=phno.getText();
bname1=bname.getText();
qty1=Integer.parseInt(qty.getText());
price1=Double.parseDouble(price.getText());
dop1=dop.getText();
String qry = "INSERT INTO customer VALUES (" + cid1 + ", '" + cname1 + "', '" + phno1 + "', '" + bname1 + "', " + qty1 + ", " + price1 + ", '" + dop1 + "')";
        int count=stm.executeUpdate(qry);
    if(count!=0)
    {
    out.setText("Entered");
    String q1="update publisher set copy=copy-"+qty1+" where name='"+bname1+"'";
    count=stm.executeUpdate(q1); 
    }
    else
    {
out.setText("Denied");
    }
stm.close();
con.close();
}
                  catch(ClassNotFoundException e)
                  {
                  System.out.println(e);
                  }
                  catch(SQLException e)
                  {
                  System.out.println(e);
                  }                 
                  }
                }); 
            }
        });

        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JFrame newFrame = new JFrame("New books Window");
                JTextField atext=new JTextField(20);
                JTextField btext=new JTextField(20);
                JTextField out=new JTextField(20);
                JButton add=new JButton("ADD");
                JLabel a=new JLabel("BookID");
                JLabel b=new JLabel("Quantity");
                newFrame.add(atext);
                newFrame.add(btext);
                newFrame.add(out);
                newFrame.add(a);
                newFrame.add(b);
                newFrame.add(add);
                newFrame.setLayout(null);
                add.setBounds(260,100,110,25);
                out.setBounds(260,140,110,25);
                a.setBounds(10,40,110,25);
                b.setBounds(10,90,110,25);
                atext.setBounds(140,40,110,25);
                btext.setBounds(140,90,110,25);
                newFrame.setSize(500, 400);
                newFrame.setVisible(true);
                add.addActionListener(new ActionListener()
                {
                 public void actionPerformed(ActionEvent x)
                  {
                   try
                   {
                    String id;
                    int qty,count;
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstall","root","2402");
                    Statement stm=con.createStatement();
                    id=atext.getText();
                    qty=Integer.parseInt(btext.getText());
                    String q1="update publisher set copy=copy+"+qty+" where bookid='"+id+"'";
                    count=stm.executeUpdate(q1);
                    if(count>=1) 
                    {
                     out.setText("Success");
                    } 
                    else
                    {
                     out.setText("Error");
                    }
                    stm.close();
                    con.close();  
                   }
                  catch(ClassNotFoundException e)
                  {
                  System.out.println(e);
                  }
                  catch(SQLException e)
                  {
                  System.out.println(e);
                  }               
                  }
                }); 
            }
        });

        frame.add(searchButton);
        frame.add(insertButton);
        frame.add(newButton);
        frame.add(updateButton);

        frame.setVisible(true);
    }
}
