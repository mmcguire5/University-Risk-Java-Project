/**
 * This class defines the functionality of each student in the game
 * It defines several methods for the purpose of making it easier to decide whether it can transfer to a certain dept or not
 */
package project;

public class Student {
	
	private static final double VOTE_FOR_OWN_CHAIR_PROBABILITY = 0.66; //Probability that this student
																	   //will vote for their chair	
	private static final double VOTE_FOR_OTHER_CHAIR_PROBABILITY = 0.34;//Probability that this student
																		//will vote for other chair
	private Player _myChair;//Player that this student is loyal to
	private Department _location;//Department in which this student resides
	/**
	 * No argument constructor that calls the setChair() method on the Player who will get this student's loyalty; also sets the
	 * department which this student belongs to originally
	 * @author mjmcguir, xingdita, norbertl
	 */
	public Student(Player c){
		setChair(c);
		
	}
	
	/**
	 * Method that sets the player to which this student will be loyal to
	 * @param c the Player who will get the loyalty
	 * @author xingdita
	 */
	public void setChair(Player c){
		_myChair = c;
	}
	
	/**
	 * Method that gets the player who this student is loyal to
	 * @return the player who this student is loyal to as a Play object
	 * @author mjmcguir
	 */
	public Player getChair(){
		return _myChair;
	}
	
	/**
	 * Method that moves this student to another department
	 * @param d the Department that this student wishes to move to
	 * @return true if the transfer follows adjacency rules and was completed; false otherwise
	 * @author xingdita, mjmcguir
	 */
	/*public boolean moveTo(Department d) {
		if(_location.canMoveTo(d)){
			_location=d;
			return true;
		}
		return false;
	}*/
	
	/**
	 * Method that determines how thi student will vote during an election (either for his loyalty or against his loyalty)
	 * @param chairWhoCallsElection the Player who calls the election
	 * @return true if this student is loyal to the initiating player and votes for his loyalty OR true if this student is not loyal
	 * to the initiating player and votes for the initiator
	 * @author xingdita, norbertl
	 */
	public boolean vote(Player chairWhoCallsElection){
		double randomNumber = Math.random();
		if(chairWhoCallsElection.equals(_myChair)){
			return randomNumber <= VOTE_FOR_OWN_CHAIR_PROBABILITY;
		}
		else{
			return randomNumber <=VOTE_FOR_OTHER_CHAIR_PROBABILITY;
		}
	}
	
	
//******************************************** Original Methods ************************************	
	
	/**
	 * Method that decides whether or not this player is in the school of Arts
	 * @param s the department that the player is in
	 * @return boolean; true if in Arts dept, false otherwise
	 * @author mjmcguir
	 */
	public static boolean isInArtsSchool(String s){ //Checks if s is in the Arts dept
        if (s == ("Music") || s == "Theatre" || s == "Dance" || s == "Visual Arts"){
            return true;
        }
        else{
            return false;
        }
	}
    
	/**
	 * Method that decides whether or not this player is in the school of Sciences
	 * @param s the department that the player is in
	 * @return boolean; true if in Sciences dept, false otherwise
	 * @author mjmcguir
	 */
    public static boolean isInSciencesSchool(String s){ //Checks if s is in the Sciences dept
            if (s == "Biology" || s == "Chemistry" || s == "Physics" || s == "Mathematics"){
                return true;
            }
            else{
                return false;
            }
        }
    
    /**
	 * Method that decides whether or not this player is in the school of Humanities
	 * @param s the department that the player is in
	 * @return boolean; true if in humanities dept, false otherwise
	 * @author mjmcguir
	 */
    public static boolean isInHumanitiesSchool(String s){ //Checks if s is in the Humanities dept
            if (s == "History" || s == "Linguistics" || s == "Literature" || s == "Religion"){
                return true;
            }
            else{
                return false;
            }
        }
    
    /**
	 * Method that decides whether or not this player is in the school of Engineering
	 * @param s the department that the player is in
	 * @return boolean; true if in Engineering dept, false otherwise
	 * @author mjmcguir
	 */
    public static boolean isInEngineeringSchool(String s){ //Checks if s is in the Engineering dept
            if (s == "Computer" || s == "Electrical" || s == "Mechanical" || s == "Civil"){
                return true;
            }
            else{
                return false;
            }
        }
    
    /**
	 * Method that decides whether or not this player is in the school of Law
	 * @param s the department that the player is in
	 * @return boolean; true if in Law dept, false otherwise
	 * @author mjmcguir
	 */
    public static boolean isInLawSchool(String s){ //Checks if s is in the Law dept
            if (s == "Business" || s == "Family" || s == "Criminal" || s == "Immigration"){
                return true;
            }
            else{
                return false;
            }
        }
    
    /**
	 * Method that decides whether or not this player is in the school of Medicine
	 * @param s the department that the player is in
	 * @return boolean; true if in Medicine dept, false otherwise
	 * @author mjmcguir
	 */
    public static boolean isInMedicineSchool(String s){ //Checks if s is in the Medicine dept
            if (s == "Anesthesia" || s == "Otolaryngology" || s == "Pathology" || s == "Pediatrics"){
                return true;
            }
            else{
                return false;
            }
        }
    
    /**
     * Method that determines,based on given specifications, whether or not a student can transfer to a given department
     * @param deptFrom of type String; the department where the student is coming from
     * @param deptTo of type String; the department where the student is trying to transfer
     * @return boolean; true if the student can transfer, false otherwise
     * @author mjmcguir
     */
    public static boolean canTransfer(String deptFrom, String deptTo){ //Checks to see if a student can transfer from
        if(isInArtsSchool(deptFrom)){ //a given department to another given department (based on rules given in user stories
            if(isInArtsSchool(deptTo)){
                return true;
            }
            else if(deptFrom == "Music" && deptTo == "Physics"){
                return true;
            }
            else if (deptFrom =="Visual Arts" && deptTo =="Mechanical"){
                return true;
            }
            else{
                return false;
            }
        }
        else if(isInSciencesSchool(deptFrom)){
            if(isInSciencesSchool(deptTo)){
                return true;
            }
            else if (deptFrom =="Physics" && deptTo =="Music"){
                return true;
            }
            else if (deptFrom == "Mathematics" && deptTo=="Religion"){
                return true;
            }
            else if(deptFrom =="Chemistry" && deptTo=="Anesthesia"){
                return true;
            }
            else{
                return false;
            }
        }
        else if(isInHumanitiesSchool(deptFrom)){
            if(isInHumanitiesSchool(deptTo)){
                return true;
            }
            else if(deptFrom =="Linguistics" && deptTo=="Computer"){
                return true;
            }
            else if(deptFrom =="Religion" && deptTo=="Mathematics"){
                return true;
            }
            else{
                return false;
            }
        }
        else if(isInEngineeringSchool(deptFrom)){
            if(isInEngineeringSchool(deptTo)){
                return true;
            }
            else if(deptFrom =="Mechanical" && deptTo=="Visual Arts"){
                return true;
            }
            else if(deptFrom =="Computer" && deptTo=="Linguistics"){
                return true;
            }
            else if(deptFrom =="Civil" && deptTo=="Business"){
                return true;
            }
            else{
                return false;
            }
        }
        else if(isInLawSchool(deptFrom)){
            if(isInLawSchool(deptTo)){
                return true;
            }
            else if(deptFrom =="Business" && deptTo=="Civil"){
                return true;
            }
            else if(deptFrom =="Criminal" && deptTo=="Pathology"){
                return true;
            }
            else{
                return false;
            }
        }
        else if(isInMedicineSchool(deptFrom)){
            if(isInMedicineSchool(deptTo)){
                return true;
            }
            else if(deptFrom =="Anesthesia" && deptTo=="Chemistry"){
                return true;
            }
            else if(deptFrom =="Pathology" && deptTo=="Criminal"){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
}
