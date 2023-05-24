import socket
import time

server = socket.socket()

server.connect(('127.0.0.1', 12345))



message = server.recv(2048)
print(message.decode())

while True:
    current_time = int(time.time())
    server.send(str(current_time).encode())
    corrected_time = server.recv(2048)
    corrected_time = corrected_time.decode()
    print(f'Received Time from Server: {corrected_time}')


