public class Codes {
    String code0 = "<pre style='background:#2B2B2B'><span class=SpellE><span\n" +
            "class=GramE><span style='font-family:Consolas;color:white;mso-themecolor:background1'>processes.sort</span></span></span><span\n" +
            "style='font-family:Consolas;color:white;mso-themecolor:background1'>(new <span\n" +
            "class=SpellE>arrivalTimeComparator</span>());</span></pre>";
    String code2 = "<pre style='background:#2B2B2B'><span style='font-family:Consolas;color:white;\n" +
            "mso-themecolor:background1'>if (<span class=SpellE>burstTime</span>[<span\n" +
            "class=SpellE>pID</span>] == <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span><span class=GramE>).<span class=SpellE>burstTime</span></span>) {<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).</span><span class=SpellE><span style='font-family:\n" +
            "Consolas;color:#FF002F'>startTime</span></span><span style='font-family:Consolas;\n" +
            "color:white;mso-themecolor:background1'> = <span class=SpellE>Math.<i>max</i></span>(</span><span\n" +
            "class=SpellE><span style='font-family:Consolas;color:#4043F5'>current_time</span></span><span\n" +
            "style='font-family:Consolas;color:white;mso-themecolor:background1'>, <span\n" +
            "class=SpellE>processes.get</span>(<span class=SpellE>pID</span>).</span><span\n" +
            "class=SpellE><span style='font-family:Consolas;color:#FFC300'>arrivalTime</span></span><span\n" +
            "style='font-family:Consolas;color:white;mso-themecolor:background1'>);<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>current_time</span> = <span\n" +
            "class=SpellE>processes.get</span>(<span class=SpellE>pID</span>).<span\n" +
            "class=SpellE>startTime</span>;<br>\n" +
            "<br>\n" +
            "}</span></pre>";
    String code3 = "<pre style='background:#2B2B2B'><span style='font-family:Consolas;color:white;\n" +
            "mso-themecolor:background1'>if (<span class=SpellE>burstTime</span>[<span\n" +
            "class=SpellE>pID</span>] == <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span><span class=GramE>).<span class=SpellE>burstTime</span></span>) {<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>startTime</span> = <span\n" +
            "class=SpellE>Math.<i>max</i></span>(<span class=SpellE>current_time</span>, <span\n" +
            "class=SpellE>processes.get</span>(<span class=SpellE>pID</span>).<span\n" +
            "class=SpellE>arrivalTime</span>);<br>\n" +
            "<span style='mso-spacerun:yes'>    </span></span><span class=SpellE><span\n" +
            "style='font-family:Consolas;color:#4043F5'>current_time</span></span><span\n" +
            "style='font-family:Consolas;color:#4043F5'> </span><span style='font-family:\n" +
            "Consolas;color:white;mso-themecolor:background1'>= <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).</span><span class=SpellE><span style='font-family:\n" +
            "Consolas;color:#FF002F'>startTime</span></span><span style='font-family:Consolas;\n" +
            "color:white;mso-themecolor:background1'>;<br>\n" +
            "<br>\n" +
            "}</span></pre>";

    String code11 = "<pre style='background:#2B2B2B'><span style='font-family:Consolas;color:white;\n" +
            "mso-themecolor:background1'>if (<span class=SpellE>burstTime</span>[<span\n" +
            "class=SpellE>pID</span>] - <span class=SpellE>timeQuantum</span> &gt; 0) {<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>burstTime</span>[<span\n" +
            "class=SpellE>pID</span>] -= <span class=SpellE>timeQuantum</span>;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span></span><span class=SpellE><span\n" +
            "style='font-family:Consolas;color:#4043F5'>current_time</span></span><span\n" +
            "style='font-family:Consolas;color:white;mso-themecolor:background1'> += </span><span\n" +
            "class=SpellE><span style='font-family:Consolas;color:#FB800E'>timeQuantum</span></span><span\n" +
            "style='font-family:Consolas;color:white;mso-themecolor:background1'>;<br>\n" +
            "}</span></pre>";

    String code4 = "<pre style='background:#2B2B2B'><span style='font-family:Consolas;color:white;\n" +
            "mso-themecolor:background1'>if (<span class=SpellE>burstTime</span>[<span\n" +
            "class=SpellE>pID</span>] - <span class=SpellE>timeQuantum</span> &gt; 0) {<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>burstTime</span>[<span\n" +
            "class=SpellE>pID</span>] -= </span><span class=SpellE><span style='font-family:\n" +
            "Consolas;color:#FB800E'>timeQuantum</span></span><span style='font-family:Consolas;\n" +
            "color:white;mso-themecolor:background1'>;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>current_time</span> += <span\n" +
            "class=SpellE>timeQuantum</span>;<br>\n" +
            "}</span></pre>";

    String code5 = "<pre style='background:#2B2B2B'><span style='font-family:Consolas;color:white;\n" +
            "mso-themecolor:background1'>else {<br>\n" +
            "<span style='mso-spacerun:yes'>    </span></span><span class=SpellE><span\n" +
            "style='font-family:Consolas;color:#4043F5'>current_time</span></span><span\n" +
            "style='font-family:Consolas;color:white;mso-themecolor:background1'> += </span><span\n" +
            "class=SpellE><span style='font-family:Consolas;color:#FFC300'>burstTime</span></span><span\n" +
            "style='font-family:Consolas;color:#FFC300'>[<span class=SpellE>pID</span>]</span><span\n" +
            "style='font-family:Consolas;color:white;mso-themecolor:background1'>;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>burstTime</span>[<span\n" +
            "class=SpellE>pID</span>] = 0;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span>counter++;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>completionTime</span> = <span\n" +
            "class=SpellE>current_time</span>;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>turnAroundTime</span> = <span\n" +
            "class=SpellE>processes.get</span>(<span class=SpellE>pID</span>).<span\n" +
            "class=SpellE>completionTime</span> - <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>arrivalTime</span>;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>waitingTime</span> = <span\n" +
            "class=SpellE>processes.get</span>(<span class=SpellE>pID</span>).<span\n" +
            "class=SpellE>turnAroundTime</span> - <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>burstTime</span>;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span>TAT += <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>turnAroundTime</span>;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span>WAT += <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>waitingTime</span>;<br>\n" +
            "<span style='mso-spacerun:yes'>  </span><span style='mso-spacerun:yes'>  </span><span\n" +
            "class=SpellE>processes.get</span>(<span class=SpellE>pID</span>).<span\n" +
            "class=SpellE>avgTurnAroundTime</span> = TAT/<span class=SpellE>processes.size</span>();<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>avgWaitingTime</span> = WAT/<span\n" +
            "class=SpellE>processes.size</span>();<br>\n" +
            "}</span></pre>";

    String code12 = "<pre style='background:#2B2B2B'><span style='font-family:Consolas;color:white;\n" +
            "mso-themecolor:background1'>else {<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>current_time</span> += <span\n" +
            "class=SpellE>burstTime</span>[<span class=SpellE>pID</span>];<br>\n" +
            "<span style='mso-spacerun:yes'>    </span></span><span class=SpellE><span\n" +
            "style='font-family:Consolas;color:#FF002F'>burstTime</span></span><span\n" +
            "style='font-family:Consolas;color:#FF002F'>[<span class=SpellE>pID</span>]</span><span\n" +
            "style='font-family:Consolas;color:white;mso-themecolor:background1'> = 0;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span>counter++;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>completionTime</span> = <span\n" +
            "class=SpellE>current_time</span>;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>turnAroundTime</span> = <span\n" +
            "class=SpellE>processes.get</span>(<span class=SpellE>pID</span>).<span\n" +
            "class=SpellE>completionTime</span> - <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>arrivalTime</span>;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>waitingTime</span> = <span\n" +
            "class=SpellE>processes.get</span>(<span class=SpellE>pID</span>).<span\n" +
            "class=SpellE>turnAroundTime</span> - <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>burstTime</span>;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span>TAT += <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>turnAroundTime</span>;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span>WAT += <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>waitingTime</span>;<br>\n" +
            "<span style='mso-spacerun:yes'>  </span><span style='mso-spacerun:yes'>  </span><span\n" +
            "class=SpellE>processes.get</span>(<span class=SpellE>pID</span>).<span\n" +
            "class=SpellE>avgTurnAroundTime</span> = TAT/<span class=SpellE>processes.size</span>();<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>avgWaitingTime</span> = WAT/<span\n" +
            "class=SpellE>processes.size</span>();<br>\n" +
            "}</span></pre>";

    String code6 = "<pre style='background:#2B2B2B'><span style='font-family:Consolas;color:white;\n" +
            "mso-themecolor:background1'>else {<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>current_time</span> += <span\n" +
            "class=SpellE>burstTime</span>[<span class=SpellE>pID</span>];<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>burstTime</span>[<span\n" +
            "class=SpellE>pID</span>] = 0;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span>counter++;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).</span><span class=SpellE><span style='font-family:\n" +
            "Consolas;color:#FFC300'>completionTime</span></span><span style='font-family:\n" +
            "Consolas;color:white;mso-themecolor:background1'> = </span><span class=SpellE><span\n" +
            "style='font-family:Consolas;color:#4043F5'>current_time</span></span><span\n" +
            "style='font-family:Consolas;color:white;mso-themecolor:background1'>;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>turnAroundTime</span> = <span\n" +
            "class=SpellE>processes.get</span>(<span class=SpellE>pID</span>).<span\n" +
            "class=SpellE>completionTime</span> - <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>arrivalTime</span>;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>waitingTime</span> = <span\n" +
            "class=SpellE>processes.get</span>(<span class=SpellE>pID</span>).<span\n" +
            "class=SpellE>turnAroundTime</span> - <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>burstTime</span>;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span>TAT += <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>turnAroundTime</span>;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span>WAT += <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>waitingTime</span>;<br>\n" +
            "<span style='mso-spacerun:yes'>  </span><span style='mso-spacerun:yes'>  </span><span\n" +
            "class=SpellE>processes.get</span>(<span class=SpellE>pID</span>).<span\n" +
            "class=SpellE>avgTurnAroundTime</span> = TAT/<span class=SpellE>processes.size</span>();<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>avgWaitingTime</span> = WAT/<span\n" +
            "class=SpellE>processes.size</span>();<br>\n" +
            "}</span></pre>";

    String code7 = "<pre style='background:#2B2B2B'><span style='font-family:Consolas;color:white;\n" +
            "mso-themecolor:background1'>else {<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>current_time</span> += <span\n" +
            "class=SpellE>burstTime</span>[<span class=SpellE>pID</span>];<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>burstTime</span>[<span\n" +
            "class=SpellE>pID</span>] = 0;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span>counter++;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>completionTime</span> = <span\n" +
            "class=SpellE>current_time</span>;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).</span><span class=SpellE><span style='font-family:\n" +
            "Consolas;color:#FFC300'>turnAroundTime</span></span><span style='font-family:\n" +
            "Consolas;color:#FFC300'> </span><span style='font-family:Consolas;color:white;\n" +
            "mso-themecolor:background1'>= <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).</span><span class=SpellE><span style='font-family:\n" +
            "Consolas;color:#FB800E'>completionTime</span></span><span style='font-family:\n" +
            "Consolas;color:#FB800E'> </span><span style='font-family:Consolas;color:white;\n" +
            "mso-themecolor:background1'>- <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).</span><span class=SpellE><span style='font-family:\n" +
            "Consolas;color:#FF002F'>arrivalTime</span></span><span style='font-family:Consolas;\n" +
            "color:white;mso-themecolor:background1'>;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>waitingTime</span> = <span\n" +
            "class=SpellE>processes.get</span>(<span class=SpellE>pID</span>).<span\n" +
            "class=SpellE>turnAroundTime</span> - <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>burstTime</span>;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span>TAT += <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>turnAroundTime</span>;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span>WAT += <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>waitingTime</span>;<br>\n" +
            "<span style='mso-spacerun:yes'>  </span><span style='mso-spacerun:yes'>  </span><span\n" +
            "class=SpellE>processes.get</span>(<span class=SpellE>pID</span>).<span\n" +
            "class=SpellE>avgTurnAroundTime</span> = TAT/<span class=SpellE>processes.size</span>();<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>avgWaitingTime</span> = WAT/<span\n" +
            "class=SpellE>processes.size</span>();<br>\n" +
            "}</span></pre>";

    String code8 = "<pre style='background:#2B2B2B'><span style='font-family:Consolas;color:white;\n" +
            "mso-themecolor:background1'>else {<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>current_time</span> += <span\n" +
            "class=SpellE>burstTime</span>[<span class=SpellE>pID</span>];<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>burstTime</span>[<span\n" +
            "class=SpellE>pID</span>] = 0;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span>counter++;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>completionTime</span> = <span\n" +
            "class=SpellE>current_time</span>;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>turnAroundTime</span> = <span\n" +
            "class=SpellE>processes.get</span>(<span class=SpellE>pID</span>).<span\n" +
            "class=SpellE>completionTime</span> - <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>arrivalTime</span>;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).</span><span class=SpellE><span style='font-family:\n" +
            "Consolas;color:#FFC300'>waitingTime</span></span><span style='font-family:Consolas;\n" +
            "color:#FFC300'> </span><span style='font-family:Consolas;color:white;\n" +
            "mso-themecolor:background1'>= <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).</span><span class=SpellE><span style='font-family:\n" +
            "Consolas;color:#FB800E'>turnAroundTime</span></span><span style='font-family:\n" +
            "Consolas;color:#FB800E'> </span><span style='font-family:Consolas;color:white;\n" +
            "mso-themecolor:background1'>- <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).</span><span class=SpellE><span style='font-family:\n" +
            "Consolas;color:#FF002F'>burstTime</span></span><span style='font-family:Consolas;\n" +
            "color:white;mso-themecolor:background1'>;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span>TAT += <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).</span><span class=SpellE><span style='font-family:\n" +
            "Consolas;color:#FB800E'>turnAroundTime</span></span><span style='font-family:\n" +
            "Consolas;color:white;mso-themecolor:background1'>;<br>\n" +
            "<span style='mso-spacerun:yes'>    </span>WAT += <span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).</span><span class=SpellE><span style='font-family:\n" +
            "Consolas;color:#FFC300'>waitingTime</span></span><span style='font-family:Consolas;\n" +
            "color:white;mso-themecolor:background1'>;<br>\n" +
            "<span style='mso-spacerun:yes'>  </span><span style='mso-spacerun:yes'>  </span><span\n" +
            "class=SpellE>processes.get</span>(<span class=SpellE>pID</span>).<span\n" +
            "class=SpellE>avgTurnAroundTime</span> = TAT/<span class=SpellE>processes.size</span>();<br>\n" +
            "<span style='mso-spacerun:yes'>    </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>pID</span>).<span class=SpellE>avgWaitingTime</span> = WAT/<span\n" +
            "class=SpellE>processes.size</span>();<br>\n" +
            "}</span></pre>";

    String code9 = "<pre style='background:#2B2B2B'><span style='font-family:Consolas;color:white;\n" +
            "mso-themecolor:background1'>if (<span class=SpellE>queue.isEmpty</span>()) {<br>\n" +
            "<span style='mso-spacerun:yes'>    </span>for (int <span class=SpellE>i</span> = 1; <span\n" +
            "class=SpellE>i</span> &lt; <span class=SpellE>processes.size</span>(); <span\n" +
            "class=SpellE>i</span>++) {<br>\n" +
            "<span style='mso-spacerun:yes'>        </span>if (<span class=SpellE>burstTime</span>[<span\n" +
            "class=SpellE>i</span>] &gt; 0) {<br>\n" +
            "<span style='mso-spacerun:yes'>            </span><span class=SpellE>queue.add</span>(<span\n" +
            "class=SpellE>i</span>);<br>\n" +
            "<span style='mso-spacerun:yes'>            </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>i</span>).visited = true;<br>\n" +
            "<span style='mso-spacerun:yes'>            </span>break;<br>\n" +
            "<span style='mso-spacerun:yes'>        </span>}<br>\n" +
            "<span style='mso-spacerun:yes'>    </span>}<br>\n" +
            "}</span></pre>";
    
    String code13 = "<pre style='background:#2B2B2B'><span style='font-family:Consolas;color:white;\n" +
            "mso-themecolor:background1'>for (int <span class=SpellE>i</span> = 1; <span\n" +
            "class=SpellE>i</span> &lt; <span class=SpellE>processes.size</span>(); <span\n" +
            "class=SpellE>i</span>++) {<br>\n" +
            "<span style='mso-spacerun:yes'>    </span>if (</span><span class=SpellE><span\n" +
            "style='font-family:Consolas;color:#FF002F'>burstTime</span></span><span\n" +
            "style='font-family:Consolas;color:#FF002F'>[<span class=SpellE>i</span>] </span><span\n" +
            "style='font-family:Consolas;color:white;mso-themecolor:background1'>&gt; 0 &amp;&amp; <span\n" +
            "class=SpellE>processes.get</span>(<span class=SpellE>i</span>).</span><span\n" +
            "class=SpellE><span style='font-family:Consolas;color:#FFC300'>arrivalTime</span></span><span\n" +
            "style='font-family:Consolas;color:white;mso-themecolor:background1'> &lt;= </span><span\n" +
            "class=SpellE><span style='font-family:Consolas;color:#4043F5'>current_time</span></span><span\n" +
            "style='font-family:Consolas;color:#4043F5'> </span><span style='font-family:\n" +
            "Consolas;color:white;mso-themecolor:background1'>&amp;&amp; !<span\n" +
            "class=SpellE>processes.get</span>(<span class=SpellE>i</span>).visited) {<br>\n" +
            "<span style='mso-spacerun:yes'>        </span><span class=SpellE>queue.add</span>(<span\n" +
            "class=SpellE>i</span>);<br>\n" +
            "<span style='mso-spacerun:yes'>        </span><span class=SpellE>processes.get</span>(<span\n" +
            "class=SpellE>i</span>).visited = true;<br>\n" +
            "<br>\n" +
            "<span style='mso-spacerun:yes'>    </span>}<br>\n" +
            "}</span></pre>";
}
