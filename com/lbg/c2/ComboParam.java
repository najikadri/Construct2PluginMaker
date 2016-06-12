package com.lbg.c2;

public class ComboParam
  extends Parameter
{
  private static final long serialVersionUID = 156887487325266189L;
  private String label;
  private String description;
  private String value;
  
  public ComboParam()
  {
    super("Combo Parameter");
  }
  
  public ComboParam(String l, String d, String v)
  {
    super("Combo Parameter");
    this.label = l;
    this.description = d;
    this.value = v;
  }
  
  public String getLabel()
  {
    return this.label;
  }
  
  public void setLabel(String label)
  {
    this.label = label;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public void setDescription(String description)
  {
    this.description = description;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public void setValue(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return String.format("Type : %s , Label : %s , Description: %s , Initial : %s", new Object[] { getType(), getLabel(), getDescription(), getValue() });
  }
}
