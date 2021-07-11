import java.util.*;

class Process{
    String process = "";
    int startTime = 0;
    int arrivalTime;
    int burstTime;
    int completionTime = 0;
    int turnAroundTime = 0;
    int waitingTime = 0;
    boolean visited;

    double avgTurnAroundTime = 0;
    double avgWaitingTime = 0;
    Process(String process, int arrivalTime, int burstTime){
        this.process = process;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.visited = false;
    }
}

class page {


    private int i;
    private int part;
    private int time;

    String[] process;
    int[] startTime;
    int[] arrivalTime;
    int[] burstTime;
    int[] completionTime;
    int[] turnAroundTime;
    int[] waitingTime;
    double[] avgTurnAroundTime;
    double[] avgWaitingTime;

    private LinkedList<Process> queue;

    public page( int part, int i, int time, String[] process, int[] startTime, int[] arrivalTime, int[] burstTime, int[] completionTime, int[] turnAroundTime, int[] waitingTime, double[] avgTurnAroundTime, double[] avgWaitingTime) {
        this.i = i;
        this.part = part;
        this.time = time;
        this.process = process;
        this.startTime = startTime;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.completionTime = completionTime;
        this.turnAroundTime = turnAroundTime;
        this.waitingTime = waitingTime;
        this.avgTurnAroundTime = avgTurnAroundTime;
        this.avgWaitingTime = avgWaitingTime;
    }

    page(LinkedList<Process> queue, int part, int i, int time){
        this.queue = queue;
        this.part = part;
        this.i = i;
        this.time = time;
    }


    public int getI() {
        return i;
    }

    public int getPart() {return part;}

    public int getTime() {return time;}

    public LinkedList<Process> getQueue(){return queue;}
}

class arrivalTimeComparator implements Comparator<Process>{
    @Override
    public int compare(Process p1, Process p2) {
        if(p1.arrivalTime < p2.arrivalTime)
            return -1;
        return 0;
    }
}
public class roundRobinUtil {


    private int timeQuantum;
    private LinkedList<Process> processes;
    private LinkedList<page> steps;


    roundRobinUtil(LinkedList<Process> queue, int timeQuantum){
        this.processes = queue;
        this.timeQuantum = timeQuantum;
    }

    public void roundRobin() {
        steps = new LinkedList<page>();
        steps.add(new page(0,0,0,
                processes.stream().map(e-> e.process).toArray(String[]::new),
                processes.stream().mapToInt(e -> e.startTime).toArray(),
                processes.stream().mapToInt(e -> e.arrivalTime).toArray(),
                processes.stream().mapToInt(e -> e.burstTime).toArray(),
                processes.stream().mapToInt(e -> e.completionTime).toArray(),
                processes.stream().mapToInt(e -> e.turnAroundTime).toArray(),
                processes.stream().mapToInt(e -> e.waitingTime).toArray(),
                processes.stream().mapToDouble(e ->  e.avgTurnAroundTime).toArray(),
                processes.stream().mapToDouble(e -> e.avgWaitingTime).toArray()

                ));

        processes.sort(new arrivalTimeComparator());
        LinkedList<Integer> queue = new LinkedList<>();

        steps.add(new page(1,0,0,
                processes.stream().map(e-> e.process).toArray(String[]::new),
                processes.stream().mapToInt(e -> e.startTime).toArray(),
                processes.stream().mapToInt(e -> e.arrivalTime).toArray(),
                processes.stream().mapToInt(e -> e.burstTime).toArray(),
                processes.stream().mapToInt(e -> e.completionTime).toArray(),
                processes.stream().mapToInt(e -> e.turnAroundTime).toArray(),
                processes.stream().mapToInt(e -> e.waitingTime).toArray(),
                processes.stream().mapToDouble(e ->  e.avgTurnAroundTime).toArray(),
                processes.stream().mapToDouble(e -> e.avgWaitingTime).toArray()
        ));
        queue.add(0);
        float TAT = 0;
        float WAT = 0;
        int counter = 0;
        int current_time = 0;
        int pID ;
        int[] burstTime = processes.stream().mapToInt(e -> e.burstTime).toArray();

        while (counter != processes.size()) {
            pID =  queue.poll();

            if (burstTime[pID] == processes.get(pID).burstTime) {
                processes.get(pID).startTime = Math.max(current_time, processes.get(pID).arrivalTime);
                steps.add(new page(2,pID,current_time,
                        processes.stream().map(e-> e.process).toArray(String[]::new),
                        processes.stream().mapToInt(e -> e.startTime).toArray(),
                        processes.stream().mapToInt(e -> e.arrivalTime).toArray(),
                        burstTime.clone(),
                        processes.stream().mapToInt(e -> e.completionTime).toArray(),
                        processes.stream().mapToInt(e -> e.turnAroundTime).toArray(),
                        processes.stream().mapToInt(e -> e.waitingTime).toArray(),
                        processes.stream().mapToDouble(e ->  e.avgTurnAroundTime).toArray(),
                        processes.stream().mapToDouble(e -> e.avgWaitingTime).toArray()
                ));
                current_time = processes.get(pID).startTime;
                steps.add(new page(3,pID,current_time,
                        processes.stream().map(e-> e.process).toArray(String[]::new),
                        processes.stream().mapToInt(e -> e.startTime).toArray(),
                        processes.stream().mapToInt(e -> e.arrivalTime).toArray(),
                        burstTime.clone(),
                        processes.stream().mapToInt(e -> e.completionTime).toArray(),
                        processes.stream().mapToInt(e -> e.turnAroundTime).toArray(),
                        processes.stream().mapToInt(e -> e.waitingTime).toArray(),
                        processes.stream().mapToDouble(e ->  e.avgTurnAroundTime).toArray(),
                        processes.stream().mapToDouble(e -> e.avgWaitingTime).toArray()
                ));
            }

            if (burstTime[pID] - timeQuantum > 0) {
                burstTime[pID] -= timeQuantum;
                steps.add(new page(4 ,pID,current_time,
                        processes.stream().map(e-> e.process).toArray(String[]::new),
                        processes.stream().mapToInt(e -> e.startTime).toArray(),
                        processes.stream().mapToInt(e -> e.arrivalTime).toArray(),
                        burstTime.clone(),
                        processes.stream().mapToInt(e -> e.completionTime).toArray(),
                        processes.stream().mapToInt(e -> e.turnAroundTime).toArray(),
                        processes.stream().mapToInt(e -> e.waitingTime).toArray(),
                        processes.stream().mapToDouble(e ->  e.avgTurnAroundTime).toArray(),
                        processes.stream().mapToDouble(e -> e.avgWaitingTime).toArray()
                ));
                current_time += timeQuantum;
                steps.add(new page(11,pID,current_time,
                        processes.stream().map(e-> e.process).toArray(String[]::new),
                        processes.stream().mapToInt(e -> e.startTime).toArray(),
                        processes.stream().mapToInt(e -> e.arrivalTime).toArray(),
                        burstTime.clone(),
                        processes.stream().mapToInt(e -> e.completionTime).toArray(),
                        processes.stream().mapToInt(e -> e.turnAroundTime).toArray(),
                        processes.stream().mapToInt(e -> e.waitingTime).toArray(),
                        processes.stream().mapToDouble(e ->  e.avgTurnAroundTime).toArray(),
                        processes.stream().mapToDouble(e -> e.avgWaitingTime).toArray()
                ));
            }
            else {
                current_time += burstTime[pID];
                steps.add(new page(5,pID,current_time,
                        processes.stream().map(e-> e.process).toArray(String[]::new),
                        processes.stream().mapToInt(e -> e.startTime).toArray(),
                        processes.stream().mapToInt(e -> e.arrivalTime).toArray(),
                        burstTime.clone(),
                        processes.stream().mapToInt(e -> e.completionTime).toArray(),
                        processes.stream().mapToInt(e -> e.turnAroundTime).toArray(),
                        processes.stream().mapToInt(e -> e.waitingTime).toArray(),
                        processes.stream().mapToDouble(e ->  e.avgTurnAroundTime).toArray(),
                        processes.stream().mapToDouble(e -> e.avgWaitingTime).toArray()
                ));

                burstTime[pID] = 0;
                steps.add(new page(12 ,pID,current_time,
                        processes.stream().map(e-> e.process).toArray(String[]::new),
                        processes.stream().mapToInt(e -> e.startTime).toArray(),
                        processes.stream().mapToInt(e -> e.arrivalTime).toArray(),
                        burstTime.clone(),
                        processes.stream().mapToInt(e -> e.completionTime).toArray(),
                        processes.stream().mapToInt(e -> e.turnAroundTime).toArray(),
                        processes.stream().mapToInt(e -> e.waitingTime).toArray(),
                        processes.stream().mapToDouble(e ->  e.avgTurnAroundTime).toArray(),
                        processes.stream().mapToDouble(e -> e.avgWaitingTime).toArray()
                ));
                counter++;

                processes.get(pID).completionTime = current_time;
                steps.add(new page(6,pID,current_time,
                        processes.stream().map(e-> e.process).toArray(String[]::new),
                        processes.stream().mapToInt(e -> e.startTime).toArray(),
                        processes.stream().mapToInt(e -> e.arrivalTime).toArray(),
                        burstTime.clone(),
                        processes.stream().mapToInt(e -> e.completionTime).toArray(),
                        processes.stream().mapToInt(e -> e.turnAroundTime).toArray(),
                        processes.stream().mapToInt(e -> e.waitingTime).toArray(),
                        processes.stream().mapToDouble(e ->  e.avgTurnAroundTime).toArray(),
                        processes.stream().mapToDouble(e -> e.avgWaitingTime).toArray()
                ));

                processes.get(pID).turnAroundTime = processes.get(pID).completionTime - processes.get(pID).arrivalTime;
                steps.add(new page(7,pID,current_time,
                        processes.stream().map(e-> e.process).toArray(String[]::new),
                        processes.stream().mapToInt(e -> e.startTime).toArray(),
                        processes.stream().mapToInt(e -> e.arrivalTime).toArray(),
                        burstTime.clone(),
                        processes.stream().mapToInt(e -> e.completionTime).toArray(),
                        processes.stream().mapToInt(e -> e.turnAroundTime).toArray(),
                        processes.stream().mapToInt(e -> e.waitingTime).toArray(),
                        processes.stream().mapToDouble(e ->  e.avgTurnAroundTime).toArray(),
                        processes.stream().mapToDouble(e -> e.avgWaitingTime).toArray()
                ));

                processes.get(pID).waitingTime = processes.get(pID).turnAroundTime - processes.get(pID).burstTime;

                TAT += processes.get(pID).turnAroundTime;
                WAT += processes.get(pID).waitingTime;
                processes.get(pID).avgTurnAroundTime = TAT/processes.size();
                processes.get(pID).avgWaitingTime = WAT/processes.size();

                steps.add(new page(8,pID,current_time,
                        processes.stream().map(e-> e.process).toArray(String[]::new),
                        processes.stream().mapToInt(e -> e.startTime).toArray(),
                        processes.stream().mapToInt(e -> e.arrivalTime).toArray(),
                        burstTime.clone(),
                        processes.stream().mapToInt(e -> e.completionTime).toArray(),
                        processes.stream().mapToInt(e -> e.turnAroundTime).toArray(),
                        processes.stream().mapToInt(e -> e.waitingTime).toArray(),
                        processes.stream().mapToDouble(e ->  e.avgTurnAroundTime).toArray(),
                        processes.stream().mapToDouble(e -> e.avgWaitingTime).toArray()
                ));
            }

            for (int i = 1; i < processes.size(); i++) {
                if (burstTime[i] > 0 && processes.get(i).arrivalTime <= current_time && !processes.get(i).visited) {
                    queue.add(i);
                    processes.get(i).visited = true;
                    steps.add(new page(13,i,current_time,
                            processes.stream().map(e-> e.process).toArray(String[]::new),
                            processes.stream().mapToInt(e -> e.startTime).toArray(),
                            processes.stream().mapToInt(e -> e.arrivalTime).toArray(),
                            burstTime.clone(),
                            processes.stream().mapToInt(e -> e.completionTime).toArray(),
                            processes.stream().mapToInt(e -> e.turnAroundTime).toArray(),
                            processes.stream().mapToInt(e -> e.waitingTime).toArray(),
                            processes.stream().mapToDouble(e ->  e.avgTurnAroundTime).toArray(),
                            processes.stream().mapToDouble(e -> e.avgWaitingTime).toArray()
                    ));
                }
            }

            if (burstTime[pID] > 0) {
                queue.add(pID);
            }

            if (queue.isEmpty()) {
                for (int i = 1; i < processes.size(); i++) {
                    if (burstTime[i] > 0) {
                        queue.add(i);
                        processes.get(i).visited = true;
                        steps.add(new page(9,pID,current_time,
                                processes.stream().map(e-> e.process).toArray(String[]::new),
                                processes.stream().mapToInt(e -> e.startTime).toArray(),
                                processes.stream().mapToInt(e -> e.arrivalTime).toArray(),
                                processes.stream().mapToInt(e -> e.burstTime).toArray(),
                                processes.stream().mapToInt(e -> e.completionTime).toArray(),
                                processes.stream().mapToInt(e -> e.turnAroundTime).toArray(),
                                processes.stream().mapToInt(e -> e.waitingTime).toArray(),
                                processes.stream().mapToDouble(e ->  e.avgTurnAroundTime).toArray(),
                                processes.stream().mapToDouble(e -> e.avgWaitingTime).toArray()
                        ));
                        break;
                    }
                }
            }

        }

        steps.add(new page(10,burstTime.length-1,current_time,
                processes.stream().map(e-> e.process).toArray(String[]::new),
                processes.stream().mapToInt(e -> e.startTime).toArray(),
                processes.stream().mapToInt(e -> e.arrivalTime).toArray(),
                processes.stream().mapToInt(e -> e.burstTime).toArray(),
                processes.stream().mapToInt(e -> e.completionTime).toArray(),
                processes.stream().mapToInt(e -> e.turnAroundTime).toArray(),
                processes.stream().mapToInt(e -> e.waitingTime).toArray(),
                processes.stream().mapToDouble(e ->  e.avgTurnAroundTime).toArray(),
                processes.stream().mapToDouble(e -> e.avgWaitingTime).toArray()
        ));

        System.out.println("Process | Turnarount_Time | waiting_Time");

        for (int i = 0; i < processes.size(); i++) {
            System.out.println(String.format("%-8s| %-16d| %d", processes.get(i).process, processes.get(i).turnAroundTime, processes.get(i).waitingTime));
        }

    }


   // }

    public LinkedList<Process> getProcesses() {
        return processes;
    }
    public LinkedList<page> getSteps() {
        return steps;
    }

    public int getTimeQuantum() {
        return timeQuantum;
    }
}
