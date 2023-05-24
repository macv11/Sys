import socket
import time
from datetime import timedelta
from _thread import *

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
server.bind(('', 12345))
server.listen(5)

def convert_time(avg_time):
    time = timedelta(seconds=avg_time)
    return str(time)


def find_average_time(times):
    return sum(times)//len(times)

def get_time(conn):
    c_time = (conn.recv(2048)).decode()
    return c_time

times = []
thread_count = 0

def handle_connections():
    conn, addr = server.accept()
    conn.send(("Connected Successfully!").encode())
    start_new_thread(handle_client, (conn,))


def handle_client(conn):
    c_time = get_time(conn)
    print(f'Received time: {c_time}')
    print(f'Server Time : {time.time()}')
    times.append(int(c_time))
    times.append(int(time.time()))
    avg_time = find_average_time(times)
    converted_avg_time = convert_time(avg_time) 
    print(times)
    print(f'Sending time {converted_avg_time} to client')
    conn.send(converted_avg_time.encode())
    times.clear()


while True:
    start_new_thread(handle_connections, ())
    thread_count+=1
    time.sleep(1)
