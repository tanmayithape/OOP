package experiment;

import java.util.Scanner;

class ChatUser extends Thread {
	    String name;
	    int messages;
	    boolean paused = false;
	    boolean stopped = false;

	    ChatUser(String name, int messages, int priority) {
	        this.name = name;
	        this.messages = messages;
	        setPriority(priority);
	    }

	    public void run() {
	        try {
	            for (int i = 1; i <= messages; i++) {

	                if (stopped)
	                    break;

	                synchronized (this) {
	                    while (paused)
	                        wait();
	                }

	                System.out.println(name + " sends message " + i);
	                Thread.sleep(1000);
	            }

	            System.out.println(name + " finished.");

	        } catch (InterruptedException e) {
	            System.out.println(name + " interrupted.");
	        }
	    }

	    void pauseChat() {
	        paused = true;
	    }

	    synchronized void resumeChat() {
	        paused = false;
	        notify();
	    }

	    void stopChat() {
	        stopped = true;
	    }
	}

	public class ChatSystemnew {
	    public static void main(String[] args) throws Exception {

	        Scanner sc = new Scanner(System.in);
	        ChatUser user1 = null, user2 = null;

	        while (true) {
	            System.out.println("\n===== CHAT MENU =====");
	            System.out.println("1. Start");
	            System.out.println("2. Pause");
	            System.out.println("3. Resume");
	            System.out.println("4. Stop");
	            System.out.println("5. Status");
	            System.out.println("6. Exit");
	            System.out.print("Enter choice: ");

	            try {
	                int choice = sc.nextInt();

	                switch (choice) {

	                    case 1:
	                        System.out.print("Enter messages: ");
	                        int n = sc.nextInt();

	                        user1 = new ChatUser("User1", n, 10);
	                        user2 = new ChatUser("User2", n, 1);

	                        user1.start();
	                        user2.start();

	                        System.out.println("Chat started.");
	                        break;

	                    case 2:
	                        if (user1 != null) {
	                            user1.pauseChat();
	                            user2.pauseChat();
	                            System.out.println("Chat paused.");
	                        } else {
	                            System.out.println("Start chat first.");
	                        }
	                        break;

	                    case 3:
	                        if (user1 != null) {
	                            user1.resumeChat();
	                            user2.resumeChat();
	                            System.out.println("Chat resumed.");
	                        } else {
	                            System.out.println("Start chat first.");
	                        }
	                        break;

	                    case 4:
	                        if (user1 != null) {
	                            user1.stopChat();
	                            user2.stopChat();
	                            System.out.println("Chat stopped.");
	                        } else {
	                            System.out.println("Start chat first.");
	                        }
	                        break;

	                    case 5:
	                        if (user1 != null) {
	                            System.out.println("User1 Alive: " + user1.isAlive());
	                            System.out.println("User2 Alive: " + user2.isAlive());
	                        } else {
	                            System.out.println("Chat not started.");
	                        }
	                        break;

	                    case 6:
	                        System.out.println("Exiting...");
	                        return;

	                    default:
	                        System.out.println("Invalid choice.");
	                }

	            } catch (Exception e) {
	                System.out.println("Enter numbers only.");
	                sc.nextLine();
	            }
	        }
	    }
	}



