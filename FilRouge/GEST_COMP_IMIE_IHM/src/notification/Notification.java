package notification;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

public class Notification
{
	private String html,status;
	private Integer projet,skill;
	
	public String getHtml()
	{
		return html;
	}
	public void setHtml(String html)
	{
		this.html = html;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public Integer getProjet()
	{
		return projet;
	}
	public void setProjet(Integer projet)
	{
		this.projet = projet;
	}
	public Integer getSkill()
	{
		return skill;
	}
	public void setSkill(Integer skill)
	{
		this.skill = skill;
	}
	
}
