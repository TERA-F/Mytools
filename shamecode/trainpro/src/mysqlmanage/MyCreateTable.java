package mysqlmanage;

import java.io.IOException;

import java.util.Vector;

class MyCreateTable{
	private String TableName;
	private String PrimaryKey;
	private String ForeignKey;
	private Vector<MyField> FieldList = new Vector<MyField>(); 
	
	
	MyCreateTable(String Name)
	{
		TableName = Name;
	}
	
	String getForeignKey()
	{
		return ForeignKey;
	}

	String getPrimaryKey()
	{
		return PrimaryKey;
	}
	
	String getTableName()
	{
		return TableName;
	}
	
	Vector<MyField> getField()
	{
		return FieldList;
	}
	
	void RemoveField(String Name) throws IOException
	{
		for(MyField tmp: FieldList)
		{
			if (tmp.getName()==Name)
				FieldList.removeElement(tmp);
			else
			{
				throw new IOException("Can't find this FieldName");
			}
		}
	}
	
	void setSinlgeField(String Name, String Define)throws IOException
	{

		for(MyField tmp:FieldList)
		{
			if(tmp.getName()==Name)
				tmp.setDefine(Define);
		}
		MyField tmp=new MyField(Name,Define);
		FieldList.add(tmp);
	}
	
	void setForeignKey(String Name) throws IOException
	{
		for(MyField tmp:FieldList)
		{
			if(tmp.getName()==Name)
				ForeignKey = Name;
		}
		throw new IOException("this FieldName isn't exist!");
	}
	
	void setPrimaryKey(String Name) throws IOException
	{
		
		for(int i = 0 ; i <FieldList.size();i++)
		{
			if(FieldList.elementAt(i).getName()==Name)
				PrimaryKey = Name;
			//if(FieldList.size()-1==i)
				//throw new IOException("this FieldName isn't exist!");
		}
	}
	
	void setTableName(String Name)
	{
		 TableName = Name;
	}
	
	String toMySQLString()
	{
		String StaName = "CREATE TABLE "+this.getTableName();
		Vector<MyField> FieldList = this.getField();
		for(int i = 0; i < FieldList.size();i++)
		{
			if(0 == i )
				StaName = StaName.concat("(");
			if((FieldList.size()-1==i)&(this.getPrimaryKey()==null))
			{
				StaName = StaName.concat(FieldList.elementAt(i).getName()).concat(" ").concat(FieldList.elementAt(i).getDefine()).concat(")");
				continue;
			}
			StaName = StaName.concat(FieldList.elementAt(i).getName()).concat(" ").concat(FieldList.elementAt(i).getDefine()).concat(",");

		}
		if(this.getPrimaryKey()!=null)
		{
			StaName = StaName.concat(" PRIMARY KEY(").concat(this.getPrimaryKey()).concat("))");//only sing key, I will fix it later.
		}
		System.out.println(StaName);
		return StaName;
	}
	
	
	class MyField
	{
		private String FieldName;
		private String FieldDefine;

		MyField(String Name, String Define)
		{
			FieldName = Name;
			FieldDefine = Define;
		}
		String getName()
		{
			return FieldName;
		}
		String getDefine()
		{
			return FieldDefine;
		}

		void setName(String Name)
		{
			FieldName = Name;
		}
		void setDefine(String Define)
		{
			FieldDefine = Define;
		}
	}
}
