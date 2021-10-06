package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Bus")
public class Bus {
	
	@Id
	private int busnumber;
		
	private String busname;

	private int seatingcapacity;
	
	private String fromroute;
	
	private String toroute;
	
	private boolean seat1;
	
	private boolean seat2;
	
	private boolean seat3;
	
	private boolean seat4;
	
	private boolean seat5;
	
	private boolean seat6;
	
	private boolean seat7;
	
	private boolean seat8;
	
	private boolean seat9;
	
	private boolean seat10;
	
	
	public Bus() {
		// TODO Auto-generated constructor stub
	}


	public int getBusnumber() {
		return busnumber;
	}


	public void setBusnumber(int busnumber) {
		this.busnumber = busnumber;
	}


	public String getBusname() {
		return busname;
	}


	public void setBusname(String busname) {
		this.busname = busname;
	}


	public int getSeatingcapacity() {
		return seatingcapacity;
	}


	public void setSeatingcapacity(int seatingcapacity) {
		this.seatingcapacity = seatingcapacity;
	}


	public String getFromroute() {
		return fromroute;
	}


	public void setFromroute(String fromroute) {
		this.fromroute = fromroute;
	}


	public String getToroute() {
		return toroute;
	}


	public void setToroute(String toroute) {
		this.toroute = toroute;
	}


	public boolean isSeat1() {
		return seat1;
	}


	public void setSeat1(boolean seat1) {
		this.seat1 = seat1;
	}


	public boolean isSeat2() {
		return seat2;
	}


	public void setSeat2(boolean seat2) {
		this.seat2 = seat2;
	}


	public boolean isSeat3() {
		return seat3;
	}


	public void setSeat3(boolean seat3) {
		this.seat3 = seat3;
	}


	public boolean isSeat4() {
		return seat4;
	}


	public void setSeat4(boolean seat4) {
		this.seat4 = seat4;
	}


	public boolean isSeat5() {
		return seat5;
	}


	public void setSeat5(boolean seat5) {
		this.seat5 = seat5;
	}


	public boolean isSeat6() {
		return seat6;
	}


	public void setSeat6(boolean seat6) {
		this.seat6 = seat6;
	}


	public boolean isSeat7() {
		return seat7;
	}


	public void setSeat7(boolean seat7) {
		this.seat7 = seat7;
	}


	public boolean isSeat8() {
		return seat8;
	}


	public void setSeat8(boolean seat8) {
		this.seat8 = seat8;
	}


	public boolean isSeat9() {
		return seat9;
	}


	public void setSeat9(boolean seat9) {
		this.seat9 = seat9;
	}


	public boolean isSeat10() {
		return seat10;
	}


	public void setSeat10(boolean seat10) {
		this.seat10 = seat10;
	}


	@Override
	public String toString() {
		return "Bus [busnumber=" + busnumber + ", busname=" + busname + ", seatingcapacity=" + seatingcapacity
				+ ", fromroute=" + fromroute + ", toroute=" + toroute + ", seat1=" + seat1 + ", seat2=" + seat2
				+ ", seat3=" + seat3 + ", seat4=" + seat4 + ", seat5=" + seat5 + ", seat6=" + seat6 + ", seat7=" + seat7
				+ ", seat8=" + seat8 + ", seat9=" + seat9 + ", seat10=" + seat10 + "]";
	}
	
	
	
}
