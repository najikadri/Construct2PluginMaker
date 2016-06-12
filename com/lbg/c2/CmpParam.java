package com.lbg.c2;

public class CmpParam
  extends Parameter
{
  private static final long serialVersionUID = -3496074396406905186L;
  private String label;
  private String description;
  
  public CmpParam()
  {
    super("Comparision Parameter");
  }
  
  public CmpParam(String l, String d)
  {
    super("Comparision Parameter");
    this.label = l;
    this.description = d;
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
  
  public String toString()
  {
    return String.format("Type : %s , Label : %s , Description: %s", new Object[] { getType(), getLabel(), getDescription() });
  }
}
