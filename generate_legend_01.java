import java.io.*;
import java.net.*;

public class generate_legend_01
{
    final static int Log_Debug_Off = 0;  // Used to turn debug off
    final static int Log_Serious = 1;    // A serious error has occurred, or we always want to output something. 
    final static int Log_Error = 2;      // An error that we can work around has occurred
    final static int Log_Warning = 3;    // Not currently used
    final static int Log_Return = 4;     // Return values from top-level subroutines

    static PrintStream myOutputOsmStream;

    final static String osmHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<osm version=\"0.6\" generator=\"OpenStreetMap server\" copyright=\"OpenStreetMap and contributors\" attribution=\"http://www.openstreetmap.org/copyright\" license=\"http://opendatacommons.org/licenses/odbl/1-0/\">\n<bounds minlat=\"-24.98769\" minlon=\"135.03282\" maxlat=\"-24.98601\" maxlon=\"135.03509\"/>";
    final static String osmTrailer = "</osm>";

    static long   startNode = 9100000000L;
    static double startLat  = -24.9850;
    static double startLon  = 135.110;
    static double incLat   = -00.0010;
    static double incLon   = 000.001;

    // qqq

    private static void writeNodeLatLon( PrintStream passedOutputOsmStream, long passedNodeNumber, double passedNodeLat, double passedNodeLon, 
					 String tag01, String value01,
					 String tag02, String value02,
					 String tag03, String value03,
					 String tag04, String value04,
					 String tag05, String value05,
					 String tag06, String value06,
					 String tag07, String value07 )
    {
	String osmLine = "";

	osmLine = "  <node id=\"" + String.valueOf( passedNodeNumber ) + "\" changeset=\"101472\" timestamp=\"2017-04-30T13:03:17Z\" version=\"1\" visible=\"true\" user=\"SomeoneElse\" uid=\"112\" lat=\"" + String.valueOf( passedNodeLat ) + "\" lon=\"" + String.valueOf( passedNodeLon ) + "\">";
	passedOutputOsmStream.println( osmLine );

	if ( !tag01.equals( "" ))
	     {
		 osmLine = "    <tag k=\"" + tag01 + "\" v=\"" + value01 + "\"/>";
		 passedOutputOsmStream.println( osmLine );
	     }

	if ( !tag02.equals( "" ))
	     {
		 osmLine = "    <tag k=\"" + tag02 + "\" v=\"" + value02 + "\"/>";
		 passedOutputOsmStream.println( osmLine );
	     }

	if ( !tag03.equals( "" ))
	     {
		 osmLine = "    <tag k=\"" + tag03 + "\" v=\"" + value03 + "\"/>";
		 passedOutputOsmStream.println( osmLine );
	     }

	if ( !tag04.equals( "" ))
	     {
		 osmLine = "    <tag k=\"" + tag04 + "\" v=\"" + value04 + "\"/>";
		 passedOutputOsmStream.println( osmLine );
	     }

	if ( !tag05.equals( "" ))
	     {
		 osmLine = "    <tag k=\"" + tag05 + "\" v=\"" + value05 + "\"/>";
		 passedOutputOsmStream.println( osmLine );
	     }

	if ( !tag06.equals( "" ))
	     {
		 osmLine = "    <tag k=\"" + tag06 + "\" v=\"" + value06 + "\"/>";
		 passedOutputOsmStream.println( osmLine );
	     }

	if ( !tag07.equals( "" ))
	     {
		 osmLine = "    <tag k=\"" + tag07 + "\" v=\"" + value07 + "\"/>";
		 passedOutputOsmStream.println( osmLine );
	     }

	osmLine = "  </node>";
	passedOutputOsmStream.println( osmLine );
    }

    // all 7 pairs of tags
    private static void writeNodeRowCol( PrintStream passedOutputOsmStream, long passedNodeNumber, int passedRow, int passedCol, 
					 String tag01, String value01, String tag02, String value02, String tag03, String value03, String tag04, String value04, String tag05, String value05, String tag06, String value06, String tag07, String value07 )
    {
	long   currentNode = startNode + ( passedRow * 10000000 ) + passedCol;
	double currentLat  = startLat  + ( incLat * passedRow );
	double currentLon  = startLon  + ( incLon * passedCol );

	writeNodeLatLon( myOutputOsmStream, currentNode, currentLat, currentLon, tag01, value01, tag02, value02, tag03, value03, tag04, value04, tag05, value05, tag06, value06, tag07, value07 );
    }

    // 2 pairs of tags
    private static void writeNodeRowCol( PrintStream passedOutputOsmStream, long passedNodeNumber, int passedRow, int passedCol, 
					 String tag01, String value01, String tag02, String value02 )
    {
	String tag03 = "";
	String value03 = "";
	String tag04   = "";
	String value04 = "";
	String tag05   = "";
	String value05 = "";
	String tag06   = "";
	String value06 = "";
	String tag07   = "";
	String value07 = "";

	writeNodeRowCol( myOutputOsmStream, startNode, passedRow, passedCol, 
			 tag01, value01, 
			 tag02, value02, 
			 tag03, value03, 
			 tag04, value04, 
			 tag05, value05, 
			 tag06, value06, 
			 tag07, value07 );
    }

    // 3 pairs of tags
    private static void writeNodeRowCol( PrintStream passedOutputOsmStream, long passedNodeNumber, int passedRow, int passedCol, 
					 String tag01, String value01, String tag02, String value02, String tag03, String value03 )
    {
	String tag04   = "";
	String value04 = "";
	String tag05   = "";
	String value05 = "";
	String tag06   = "";
	String value06 = "";
	String tag07   = "";
	String value07 = "";

	writeNodeRowCol( myOutputOsmStream, startNode, passedRow, passedCol, 
			 tag01, value01, 
			 tag02, value02, 
			 tag03, value03, 
			 tag04, value04, 
			 tag05, value05, 
			 tag06, value06, 
			 tag07, value07 );
    }

    // all 7 pairs of tags
    private static void writeLabelledNodeRowCol( PrintStream passedOutputOsmStream, long passedNodeNumber, int passedRow, int passedCol, String labelName, 
					 String tag01, String value01, String tag02, String value02, String tag03, String value03, String tag04, String value04, String tag05, String value05, String tag06, String value06, String tag07, String value07 )
    {
	long   currentNode = startNode + ( passedRow * 10000000 ) + passedCol;
	double currentLat  = startLat  + ( incLat * passedRow );
	double currentLon  = startLon  + ( incLon * passedCol );

	writeNodeLatLon( myOutputOsmStream, currentNode, currentLat, currentLon, tag01, value01, tag02, value02, tag03, value03, tag04, value04, tag05, value05, tag06, value06, tag07, value07 );

	currentNode = startNode + ( passedRow * 10000000 ) + 1000000 + passedCol;
	currentLat  = startLat  + ( incLat * passedRow ) + 0.0002;
	currentLon  = startLon  + ( incLon * passedCol );

	writeNodeLatLon( myOutputOsmStream, currentNode, currentLat, currentLon, "place", "legend_text", "name", labelName, "", "", "", "", "", "", "", "", "", "" );
    }

    // 2 pairs of tags
    private static void writeLabelledNodeRowCol( PrintStream passedOutputOsmStream, long passedNodeNumber, int passedRow, int passedCol, String labelName, 
					 String tag01, String value01, String tag02, String value02 )
    {
	String tag03 = "";
	String value03 = "";
	String tag04   = "";
	String value04 = "";
	String tag05   = "";
	String value05 = "";
	String tag06   = "";
	String value06 = "";
	String tag07   = "";
	String value07 = "";

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, passedRow, passedCol, labelName, 
			 tag01, value01, 
			 tag02, value02, 
			 tag03, value03, 
			 tag04, value04, 
			 tag05, value05, 
			 tag06, value06, 
			 tag07, value07 );
    }

    // 3 pairs of tags
    private static void writeLabelledNodeRowCol( PrintStream passedOutputOsmStream, long passedNodeNumber, int passedRow, int passedCol, String labelName, 
					 String tag01, String value01, String tag02, String value02, String tag03, String value03 )
    {
	String tag04   = "";
	String value04 = "";
	String tag05   = "";
	String value05 = "";
	String tag06   = "";
	String value06 = "";
	String tag07   = "";
	String value07 = "";

	writeLabelledNodeRowCol( myOutputOsmStream, startNode, passedRow, passedCol, labelName, 
			 tag01, value01, 
			 tag02, value02, 
			 tag03, value03, 
			 tag04, value04, 
			 tag05, value05, 
			 tag06, value06, 
			 tag07, value07 );
    }

    public static void main(String[] args) throws Exception 
    {
	// No argument processing (yet)

	String osmLegendFile01 = "generated_legend_pub.osm"; 
	myOutputOsmStream = new PrintStream( osmLegendFile01 );
	myOutputOsmStream.println( osmHeader );

	// Row 0 - a descriptive label
	int currentRow = 0;
	int currentCol = 5; // Displayed at col 5 to shift to right
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "place", "village", 
			 "name", "Zoom in to see items rendered at each zoom level:" );

	// Row 1 - pubs
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Pubs", 
				 "amenity", "pub", 
				 "name", "Generic Pub" );
	
	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "pub", 
			 "name", "Real Ale", 
			 "real_ale", "An interesting selection" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "pub", 
			 "name", "No Real Ale", 
			 "real_ale", "no" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "pub", 
			 "name", "Food", 
			 "food", "Some sort of description" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "pub", 
			 "name", "Non-carpeted area", 
			 "description:floor", "Tiles or Stone" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "pub", 
			 "name", "Pub with Microbrewery", 
			 "microbrewery", "yes" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "pub", 
			 "name", "Combination", 
			 "real_ale", "An interesting selection", 
			 "food", "Some sort of description", 
			 "microbrewery", "yes", 
			 "description:floor", "Tiles or stone",
			 "", "" );

	// Row 2 - fast food
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Fast Food", 
				 "amenity", "fast_food", 
				 "name", "Generic Fast Food" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "American, Burger", 
			 "cuisine", "burger" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Chicken", 
			 "cuisine", "chicken" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Chinese, Japanese, etc.", 
			 "cuisine", "chinese" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Coffee", 
			 "cuisine", "coffee" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Fish and Chips", 
			 "cuisine", "fish_and_chips" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Ice Cream", 
			 "cuisine", "ice_cream" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Indian", 
			 "cuisine", "indian" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Kebab, Turkish", 
			 "cuisine", "kebab" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Pies, Pasties", 
			 "cuisine", "pie" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Pizza, Italian", 
			 "cuisine", "pizza" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "fast_food", 
			 "name", "Sandwich", 
			 "cuisine", "sandwich" );

	// Row 3 - other eating and drinking
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Other Eating and Drinking", 
				 "amenity", "bar", 
				 "name", "Bar" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "social_club", 
			 "name", "Social Club" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "cafe", 
			 "name", "Cafe" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "restaurant", 
			 "name", "Restaurant" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "biergarten", 
			 "name", "Biergarten" );

	// Row 4 - shops
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Shops", 
				 "shop", "yes", 
				 "name", "Generic Shop" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "convenience",
			 "name", "Convenience, Kiosk, Newsagent, Food" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "supermarket", 
			 "name", "Supermarket" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "clothes", 
			 "name", "Clothes, Shoes, Boutique, Tailor, Fashion, Baby Goods" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "hairdresser", 
			 "name", "Hairdresser" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "bakery", 
			 "name", "Bakery" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "butcher", 
			 "name", "Butcher" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "florist", 
			 "name", "Florist" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "doityourself", 
			 "name", "Do-It-Yourself, Hardware" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "electrical", 
			 "name", "Electronics, Electrical" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "bicycle", 
			 "name", "Bike Shop" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "jewellery", 
			 "name", "Jewellery, Watches" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "department_store", 
			 "name", "Department Store" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "greengrocer", 
			 "name", "Greengrocer" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "sports", 
			 "name", "Sports, Fishing, Scuba Diving" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "garden_centre", 
			 "name", "Garden Centre" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "outdoor", 
			 "name", "Outdoor" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "pawnbroker", 
			 "name", "Pawnbroker, Money Lender" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "estate_agent", 
			 "name", "Estate Agent" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "charity", 
			 "name", "Charity" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "antiques", 
			 "name", "Antiques" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "e-cigarette", 
			 "name", "E-Cigarette" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "variety_store", 
			 "name", "Variety, Discount" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "shop", "funeral_directors", 
			 "name", "Funerals, Stonemasons, etc." );

	// Row 5 - cars
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Petrol / Diesel", 
				 "amenity", "fuel", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Car Sales",
				 "shop", "car", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Car Repair",
				 "shop", "car_repair", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Car Parts",
				 "shop", "car_parts", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Car Wash",
				 "amenity", "car_wash", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Other Car (rental etc.)",
				 "amenity", "car_rental", 
				 "name", "Name" );

	// Row 6 - generic
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Vacant", 
				 "shop", "vacant", 
				 "", "" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Various Offices", 
				 "office", "yes", 
				 "name", "Office Name" );

	// Row 7 - medical
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Hospital", 
				 "amenity", "hospital", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Doctors",
				 "amenity", "doctors", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Dentist",
				 "amenity", "dentist", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Other Healthcare",
				 "shop", "optician", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Pharmacy",
				 "amenity", "pharmacy", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Defibrillator", 
				 "emergency", "defibrillator", 
				 "name", "Defibrillator" );

	// Row 8 - accomodation
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Hotel", 
				 "tourism", "hotel", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Motel", 
			 "tourism", "motel", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Resort", 
			 "leisure", "resort", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Guest House",
			 "tourism", "guest_house", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bed and Breakfast",
			 "tourism", "bed_and_breakfast", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Chalet",
			 "tourism", "chalet", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Alpine Hut",
			 "tourism", "alpine_hut", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Hostel",
			 "tourism", "hostel", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Caravan Site",
			 "tourism", "caravan_site", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Camp Site",
			 "tourism", "camp_site", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Firepit", 
				 "leisure", "firepit", 
				 "name", "Name" );

	// Row 9 - big places you might want to visit
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Other Tourism", 
				 "amenity", "cinema", 
				 "name", "Cinema" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "concert_hall", 
			 "name", "Concert Hall" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "library", 
			 "name", "Library" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "theatre", 
			 "name", "Theatre" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "museum", 
			 "name", "Museum" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "aquarium", 
			 "name", "Aquarium" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "zoo", 
			 "name", "Zoo" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "theme_park", 
			 "name", "Theme Park" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "attraction", 
			 "name", "Attraction" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Toilets", 
				 "amenity", "toilets", 
				 "name", "Name" );

	// Row 10 - places you might want to visit outside
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Picnic Site", 
				 "tourism", "picnic_site", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Shelter", 
				 "amenity", "shelter", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Picnic Table", 
				 "leisure", "picnic_table", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Playground", 
				 "leisure", "playground", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Slipway", 
				 "leisure", "slipway", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Marina", 
				 "leisure", "marina", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bird Hide", 
				 "leisure", "bird_hide", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Trig Point", 
				 "man_made", "survey_point", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Cairn", 
				 "man_made", "cairn", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Well", 
				 "man_made", "water_well", 
				 "name", "Name" );

	// Row 11 - Leisure
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Sports Centre",
			 "leisure", "sports_centre", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Swimming Pool",
			 "leisure", "swimming_pool", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Swimming Area",
			 "leisure", "swimming_area", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Water Park",
			 "leisure", "water_park", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Ice Rink",
			 "leisure", "ice_rink", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Stadium",
			 "leisure", "stadium", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Golf Course",
			 "leisure", "golf_course", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bowling Alley",
			 "leisure", "bowling_alley", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Rec. Ground",
			 "leisure", "recreation_ground", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Dancing", 
				 "leisure", "dance", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Club", 
				 "leisure", "club", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Fitness Centre", 
				 "leisure", "fitness_centre", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Fitness Station", 
				 "leisure", "fitness_station", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Dog Park", 
				 "leisure", "dog_park", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Sauna", 
				 "leisure", "sauna", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Horse Riding", 
				 "leisure", "horse_riding", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Mini Golf", 
				 "leisure", "miniature_golf", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Fishing", 
				 "leisure", "fishing", 
				 "name", "Name" );

	// Row 12 - Tourist Information
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Tourist Information", 
				 "tourism", "information", 
				 "name", "Generic Information" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "information", 
			 "information", "board", 
			 "name", "Board" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "information", 
			 "information", "guidepost", 
			 "name", "Guidepost" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "information", 
			 "information", "route_marker", 
			 "name", "Route marker" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "information", 
			 "information", "office", 
			 "name", "Office" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "information", 
			 "information", "plaque", 
			 "name", "Plaque" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "information", 
			 "information", "audioguide", 
			 "name", "Audioguide" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "tourism", "information", 
			 "operator", "Peak and Northern Footpaths Society",
			 "ref", "Ref",
			 "name", "PNFS Signpost",
			 "", "",
			 "", "",
			 "", "" );

	// Row 13 - religious
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Places of Worship", 
				 "amenity", "place_of_worship", 
				 "religion", "christian", 
				 "name", "Christian" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "place_of_worship", 
			 "religion", "muslim", 
			 "name", "Muslim" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "place_of_worship", 
			 "religion", "hindu", 
			 "name", "Hindu" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "place_of_worship", 
			 "religion", "sikh", 
			 "name", "Sikh" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "place_of_worship", 
			 "religion", "jewish", 
			 "name", "Jewish" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "place_of_worship", 
			 "religion", "buddhist", 
			 "name", "Buddhist" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "place_of_worship", 
			 "religion", "shinto", 
			 "name", "Shinto" );

	currentCol += 1;
	writeNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, 
			 "amenity", "place_of_worship", 
			 "religion", "taoist", 
			 "name", "Taoist" );

	// Row 14 - government
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Post Office", 
				 "amenity", "post_office", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Fire", 
			 "amenity", "fire_station", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Police", 
			 "amenity", "police", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Ambulance", 
			 "amenity", "ambulance_station", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Embassy", 
			 "amenity", "embassy", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Courthouse", 
			 "amenity", "courthouse", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Prison", 
			 "amenity", "prison", 
			 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Other", 
			 "office", "government", 
			 "name", "Name" );

	// Row 15 - financial
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bank / Building Society", 
				 "amenity", "bank", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "ATM", 
				 "amenity", "atm", 
				 "operator", "Operator" );

	// Row 16 - education
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "University", 
				 "amenity", "university", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "School / College", 
				 "amenity", "school", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Kindergarten", 
				 "amenity", "kindergarten", 
				 "name", "Name" );

	// Row 15 - smaller amenities
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Viewpoint", 
				 "tourism", "viewpoint", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Artwork", 
				 "tourism", "artwork", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Sundial", 
				 "amenity", "sundial", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Postbox", 
				 "amenity", "post_box", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Telephone", 
				 "amenity", "telephone", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Shopmobility", 
				 "amenity", "shopmobility", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Left Luggage", 
				 "amenity", "left_luggage", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Parcel Locker", 
				 "amenity", "parcel_locker", 
				 "name", "Operator" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Vending Machine", 
				 "amenity", "vending_machine", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Recycling", 
				 "amenity", "recycling", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Wastebasket", 
				 "amenity", "waste_basket", 
				 "", "" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bench", 
				 "amenity", "bench", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Water", 
				 "amenity", "drinking_water", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Memorial", 
				 "historic", "memorial", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Ruins", 
				 "historic", "ruins", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Archaeology", 
				 "historic", "archaeological_site", 
				 "name", "Name" );

	// Row 17 - Travel infrastructure
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Car Park", 
				 "amenity", "parking", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "(pay)", 
				 "amenity", "parking", 
				 "fee", "yes", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "(private)", 
				 "amenity", "parking", 
				 "access", "private", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Car Sharing", 
				 "amenity", "car_sharing", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Rail Station", 
				 "railway", "station", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Rail Halt", 
				 "railway", "halt", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bus Station", 
				 "amenity", "bus_station", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bus Stop", 
				 "highway", "bus_stop", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Ferry Terminal", 
				 "amenity", "ferry_terminal", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bike Parking", 
				 "amenity", "bicycle_parking", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bike Rental", 
				 "amenity", "bicycle_rental", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Airport", 
				 "aeroway", "aerodrome", 
				 "iata", "IATA", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Heliport", 
				 "aeroway", "heliport", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Helipad", 
				 "aeroway", "helipad", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Gate", 
				 "aeroway", "gate", 
				 "ref", "Ref" );

	// Row 18 - Travel infrastructure
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Traf. Lights", 
				 "highway", "traffic_signals", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Crossing", 
				 "highway", "crossing", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Milestone", 
				 "highway", "milestone", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Mini Rndbt", 
				 "highway", "mini_roundabout", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Gate", 
				 "barrier", "gate", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Kissing Gate", 
				 "barrier", "kissing_gate", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Stile", 
				 "barrier", "stile", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Horse Stile", 
				 "barrier", "horse_stile", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Cycle Barrier", 
				 "barrier", "cycle_barrier", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Cattle Grid", 
				 "barrier", "cattle_grid", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Lift Gate", 
				 "barrier", "lift_gate", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Bollard", 
				 "barrier", "bollard", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Phone", 
				 "emergency", "phone", 
				 "name", "Name" );

	// Row 19 - Towers etc.
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Mast", 
				 "man_made", "mast", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Chimney", 
				 "man_made", "chimney", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Water Tower", 
				 "man_made", "water_tower", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Lighthouse", 
				 "man_made", "lighthouse", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Wind Turbine", 
				 "man_made", "power_wind", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Windmill", 
				 "man_made", "windmill", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Vent Shaft", 
				 "man_made", "ventilation_shaft", 
				 "name", "Name" );

	// Row 20 - Natural
	currentRow += 1;
	currentCol = 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Peak", 
				 "natural", "peak", 
				 "name", "Name / ele" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Volcano", 
				 "natural", "volcano", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Cave", 
				 "natural", "cave_entrance", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Spring", 
				 "natural", "spring", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Sluice", 
				 "waterway", "sluice_gate", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Lock Gate", 
				 "waterway", "lock_gate", 
				 "name", "Name" );

	currentCol += 1;
	writeLabelledNodeRowCol( myOutputOsmStream, startNode, currentRow, currentCol, "Tree", 
				 "natural", "tree", 
				 "name", "Name" );

	myOutputOsmStream.println( osmTrailer );
    }
}
