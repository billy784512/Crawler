
public class Web {
	
	public String url,name;
	public double score;
	
	public Web (String name,String url,double score){
		this.name = name;
		this.url = url;
		this.score = score;
	}
	
	public String toString() {
		return name+"\n"+url+"\n總分： "+score+"\n";
	}
}