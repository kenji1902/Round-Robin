import java.util.*;

class Process{
    String process;
    int startTime;
    int arrivalTime;
    int burstTime;
    int completionTime;
    int turnAroundTime;
    int waitingTime;
    boolean visited;

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
    private LinkedList<Process> queue;
    page(LinkedList<Process> queue,int part,int i,int time){
        this.queue = new LinkedList<Process>();
        this.queue = (LinkedList<Process>) queue.clone();
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
        steps.add(new page(processes,0,0,0));

        processes.sort(new arrivalTimeComparator());
        LinkedList<Integer> queue = new LinkedList<>();

        steps.add(new page(processes,1,0,0));
        queue.add(0);
        int counter = 0;
        int current_time = 0;
        int total_idle_time = 0;
        int idx ;
        int[] burstTime = processes.stream().mapToInt(e -> e.burstTime).toArray();

        while (counter != processes.size()) {
            idx =  queue.poll();

            if (burstTime[idx] == processes.get(idx).burstTime) {
                processes.get(idx).startTime = Math.max(current_time, processes.get(idx).arrivalTime);
                steps.add(new page(processes,2,idx,current_time));
                total_idle_time += processes.get(idx).startTime - current_time;
                current_time = processes.get(idx).startTime;
                steps.add(new page(processes,3,idx,current_time));
            }

            if (burstTime[idx] - timeQuantum > 0) {
                burstTime[idx] -= timeQuantum;
                steps.add(new page(processes,4 ,idx,current_time));
                current_time += timeQuantum;
                steps.add(new page(processes,3,idx,current_time));
            }
            else {
                current_time += burstTime[idx];
                steps.add(new page(processes,5,idx,current_time));

                burstTime[idx] = 0;
                steps.add(new page(processes,3 ,idx,current_time));
                counter++;

                processes.get(idx).completionTime = current_time;
                steps.add(new page(processes,6,idx,current_time));

                processes.get(idx).turnAroundTime = processes.get(idx).completionTime - processes.get(idx).arrivalTime;
                steps.add(new page(processes,7,idx,current_time));

                processes.get(idx).waitingTime = processes.get(idx).turnAroundTime - processes.get(idx).burstTime;
                steps.add(new page(processes,8,idx,current_time));

                //p[idx].response_time = p[idx].start_time - p[idx].arrival_time;

                //total_turnaround_time += p[idx].turnaround_time;
                //total_waiting_time += p[idx].waiting_time;
                //total_response_time += p[idx].response_time;
            }

            for (int i = 1; i < processes.size(); i++) {
                if (burstTime[i] > 0 && processes.get(i).arrivalTime <= current_time && !processes.get(i).visited) {
                    queue.add(i);
                    processes.get(i).visited = true;
                }
            }

            if (burstTime[idx] > 0) {
                queue.add(idx);
            }

            if (queue.isEmpty()) {
                for (int i = 1; i < processes.size(); i++) {
                    if (burstTime[i] > 0) {
                        queue.add(i);
                        processes.get(i).visited = true;
                        steps.add(new page(processes,9,idx,current_time));
                        break;
                    }
                }
            }

        }
        steps.add(new page(processes,10,0,current_time));

        System.out.println("Process | Turnarount_Time | waiting_Time");

        for (int i = 0; i < processes.size(); i++) {
            System.out.println(String.format("%-8s| %-16d| %d", processes.get(i).process, processes.get(i).turnAroundTime, processes.get(i).waitingTime));
        }

    }
    // System.out.println("Process | Turnarount_Time | waiting_Time");
     //   System.out.println(String.format("%-8s| %-16d| %d", processes.get(i).process, turnAroundTime[i], waitingTime[i]));


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
