package IPL_java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.MathContext;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final int MATCH_ID = 0;
    private static final int MATCH_SEASON= 1;
    private static final int MATCH_CITY = 2;
    private static final int MATCH_DATE = 3;
    private static final int MATCH_TEAM1 = 4;
    private static final int  MATCH_TEAM2 = 5;
    private static final int MATCH_TOSS_WINNER = 6 ;
    private static final int  MATCH_TOSS_DECISION = 7;
    private static final int  MATCH_RESULT = 8;
    private static final int  MATCH_DL_APPLIED = 9;
    private static final int  MATCH_WINNER = 10;
    private static final int  MATCH_WIN_BY_RUNS = 11;
    private static final int  MATCH_WIN_BY_WICKETS = 12;
    private static final int  MATCH_PLAYER_OF_MATCH = 13;
    private static final int MATCH_VENUE = 14;
    private static final int  MATCH_UMPIRE_1 = 15;
    private static final int  MATCH_UMPIRE_2 = 16;


    private static final int DELIVERY_MATCH_ID = 0;
    private static final int DELIVERY_INNING = 1;
    private static final int DELIVERY_BATTING_TEAM = 2;
    private static final int DELIVERY_BOWLING_TEAM = 3;
    private static final int DELIVERY_OVER = 4;
    private static final int DELIVERY_BALL = 5;
    private static final int DELIVERY_BATSMAN = 6;
    private static final int DELIVERY_NON_STRIKER = 7;
    private static final int DELIVERY_BOWLER = 8;
   private static final int DELIVERY_IS_SUPER_OVER = 9;
    private static final int DELIVERY_WIDE_RUNS = 10;
    private static final int DELIVERY_BYE_RUNS = 11;
    private static final int DELIVERY_LEG_BYE_RUNS = 12;
    private static final int DELIVERY_NO_BALL_RUNS = 13;
    private static final int DELIVERY_PENALTY_RUNS = 14;
    private static final int DELIVERY_BATSMAN_RUNS = 15;
    private static final int DELIVERY_EXTRA_RUNS = 16;
    private static final int DELIVERY_TOTAL_RUNS = 17;
    private static final int DELIVERY_PLAYER_DISMISSED = 18;
    private static final int DELIVERY_DISMISSAL_KIND = 19;
    private static final int DELIVERY_FIELDER = 20;

    public static List<Match> getMatchesData() throws IOException {
        List<Match> matches = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("/home/dhwaj/MountBlue_QA/IPL_java/matches.csv"))) {
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", -1);  // Use -1 to include empty values

                if (data.length >= MATCH_UMPIRE_2 + 1) {  // Check array length before accessing indices
                    Match match = new Match();
                    match.setId(data[MATCH_ID]);
                    match.setSeason(data[MATCH_SEASON]);
                    match.setVenue(data[MATCH_CITY]);
                    match.setDate(data[MATCH_DATE]);
                    match.setTeam1(data[MATCH_TEAM1]);
                    match.setTeam2(data[MATCH_TEAM2]);
                    match.setToss_winner(data[MATCH_TOSS_WINNER]);
                    match.setToss_decision(data[MATCH_TOSS_DECISION]);
                    match.setResult(data[MATCH_RESULT]);
                    match.setDl_applied(data[MATCH_DL_APPLIED]);
                    match.setWinner(data[MATCH_WINNER]);
                    match.setWin_by_runs(data[MATCH_WIN_BY_RUNS]);
                    match.setWin_by_wickets(data[MATCH_WIN_BY_WICKETS]);
                    match.setPlayer_of_match(data[MATCH_PLAYER_OF_MATCH]);
                    match.setVenue(data[MATCH_VENUE]);
                    match.setUmpire1(data[MATCH_UMPIRE_1]);
                    match.setUmpire2(data[MATCH_UMPIRE_2]);

                    matches.add(match);
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return matches;
    }

    public static List<Delivery> getDeliveriesData() throws IOException {
        List<Delivery> deliveries = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("/home/dhwaj/MountBlue_QA/IPL_java/deliveries.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", -1);  // Use -1 to include empty values

                if (data.length >= DELIVERY_FIELDER + 1) {  // Check array length before accessing indices
                    Delivery delivery = new Delivery();
                    delivery.setMatch_id(data[DELIVERY_MATCH_ID]);
                    delivery.setInning(data[DELIVERY_INNING]);
                    delivery.setBatting_team(data[DELIVERY_BATTING_TEAM]);
                    delivery.setBowling_team(data[DELIVERY_BOWLING_TEAM]);
                    delivery.setOver(data[DELIVERY_OVER]);
                    delivery.setBall(data[DELIVERY_BALL]);
                    delivery.setBatsman(data[DELIVERY_BATSMAN]);
                    delivery.setNon_striker(data[DELIVERY_NON_STRIKER]);
                    delivery.setBowler(data[DELIVERY_BOWLER]);
                    delivery.setIs_super_over(data[DELIVERY_IS_SUPER_OVER]);
                    delivery.setWide_runs(data[DELIVERY_WIDE_RUNS]);
                    delivery.setBye_runs(data[DELIVERY_BYE_RUNS]);
                    delivery.setLegbye_runs(data[DELIVERY_LEG_BYE_RUNS]);
                    delivery.setNoball_runs(data[DELIVERY_NO_BALL_RUNS]);
                    delivery.setPenalty_runs(data[DELIVERY_PENALTY_RUNS]);
                    delivery.setBatsman_runs(data[DELIVERY_BATSMAN_RUNS]);
                    delivery.setExtra_runs(data[DELIVERY_EXTRA_RUNS]);
                    delivery.setTotal_runs(data[DELIVERY_TOTAL_RUNS]);
                    delivery.setPlayer_dismissed(data[DELIVERY_PLAYER_DISMISSED]);
                    delivery.setDismissal_kind(data[DELIVERY_DISMISSAL_KIND]);
                    delivery.setFielder(data[DELIVERY_FIELDER]);

                    deliveries.add(delivery);
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        return deliveries;
    }

//    Number of matches played per year of all the years in IPL.
    private static void findNumberOfMatchesPlayedPerYear(List<Match> matches){
    HashMap<String , Integer> matchesPlayedPerYear = new HashMap<>();
    for(Match match : matches){
        String season = match.getSeason();
    matchesPlayedPerYear.put(season,matchesPlayedPerYear.getOrDefault(season,0 )+1);
    }
        System.out.println("Number of matches played per year :");
        System.out.println(matchesPlayedPerYear);

    }


//    Number of matches won of all teams over all the years of IPL.
    private static void numberOfMatchesWonByAllTeams(List<Match> matches) {

    HashMap<String,HashMap<String,Integer>> totalMatchesWonPerTeam = new HashMap<>();
    for(Match match : matches){
        String season = match.getSeason();
        String winner = match.getWinner();

        if(totalMatchesWonPerTeam.containsKey(season)){
            HashMap<String,Integer> teamWins = totalMatchesWonPerTeam.get(season);
        if(teamWins.containsKey(winner)){
            teamWins.put(winner,teamWins.get(winner)+1);
        }else{
            teamWins.put(winner,1);
        }
        }else{
            HashMap<String,Integer> teamWins = new HashMap<>();
            teamWins.put(winner , 1);
            totalMatchesWonPerTeam.put(season,teamWins);
        }
    }
        System.out.println("matches won per team per year :");
        System.out.println(totalMatchesWonPerTeam);
    }

//    For the year 2016 get the extra runs conceded per team.
    private static void ExtraRunConcedePerTeam(List<Match> matches , List<Delivery> deliveries){
        HashMap<String,Integer> extraRunConcedePerTeam2016 = new HashMap<>();
        for(Match match : matches){
            if(match.getSeason().equals("2016")){
                for(Delivery delivery : deliveries){
                    if(match.getId().equals(delivery.getMatch_id())){
                        extraRunConcedePerTeam2016.put(delivery.getBowling_team(),extraRunConcedePerTeam2016.getOrDefault(delivery.getBowling_team(),0) + Integer.parseInt(delivery.getExtra_runs()));
                    }
                }
            }
        }
        System.out.println("Extra runs conceded per team in 2016");
        System.out.println(extraRunConcedePerTeam2016);

    }
//    For the year 2015 get the top economical bowlers.
    private static void Top10EconomicalBowler(List<Match> matches , List<Delivery> deliveries) {
        Set<String> matchIds2015 = new HashSet<>();
        for(Match match : matches){
            if("2015".equals(match.getSeason())){
                matchIds2015.add(match.getId());
            }
        }
//        System.out.println(matchIds2015);
        HashMap<String,Integer> noOfBalls = new HashMap<>();
        HashMap<String,Integer> noOfRuns = new HashMap<>();
        HashMap<String,String> economiesOfBowler = new HashMap<>();

        for(Delivery delivery : deliveries){
            if(matchIds2015.contains(delivery.getMatch_id())){
                if("0".equals(delivery.getWide_runs()) && "0".equals(delivery.getNoball_runs())){
                    noOfBalls.put(delivery.getBowler(),noOfBalls.getOrDefault(delivery.getBowler(),0)+1);
                }
                int totalRuns = Integer.parseInt(delivery.getTotal_runs());
                int penaltyRuns = Integer.parseInt(delivery.getPenalty_runs());
                int legByeRuns = Integer.parseInt(delivery.getLegbye_runs());
                int byeRuns = Integer.parseInt(delivery.getBye_runs());

                int bowlerConsiderRuns = totalRuns - penaltyRuns - legByeRuns - byeRuns;
                noOfRuns.put(delivery.getBowler(),noOfRuns.getOrDefault(delivery.getBowler(),0) + bowlerConsiderRuns);
            }
        }
        for (String bowler : noOfBalls.keySet()) {
            int balls = noOfBalls.get(bowler);
            int runs = noOfRuns.getOrDefault(bowler, 0);

            double economy = ((double) runs / balls) * 6.0;
            economiesOfBowler.put(bowler, String.format("%.2f", economy));
        }

        System.out.println(economiesOfBowler);

        List<Map.Entry<String, String>> sortedEconomy = new ArrayList<>(economiesOfBowler.entrySet());
        sortedEconomy.sort(Comparator.comparingDouble(entry -> Double.parseDouble(entry.getValue())));

        System.out.println(sortedEconomy.subList(0, Math.min(10, sortedEconomy.size())));


    }

    public static void main(String[] args) throws IOException
    {
        List<Match> matches = getMatchesData();
        List<Delivery> deliveries = getDeliveriesData();
        findNumberOfMatchesPlayedPerYear(matches);
        numberOfMatchesWonByAllTeams(matches);
        ExtraRunConcedePerTeam(matches,deliveries);
        Top10EconomicalBowler(matches,deliveries);

    }
}

