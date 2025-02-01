package dev.memocode.tcp2;

import com.ghgande.j2mod.modbus.io.ModbusTCPTransaction;
import com.ghgande.j2mod.modbus.msg.ReadMultipleRegistersRequest;
import com.ghgande.j2mod.modbus.msg.ReadMultipleRegistersResponse;
import com.ghgande.j2mod.modbus.msg.WriteSingleRegisterRequest;
import com.ghgande.j2mod.modbus.net.TCPMasterConnection;
import com.ghgande.j2mod.modbus.procimg.SimpleRegister;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

@Configuration
public class TestConfig {

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
//            TCPMasterConnection connection = null; // Modbus TCP connection
//            ModbusTCPTransaction transaction = null; // Modbus TCP transaction
//            int unitId = 1; // Modbus Slave Unit ID (1 by default)
//            String modbusHost = "192.168.50.9"; // Modbus server IP
//            int port = 502; // Modbus TCP port
//
//            try {
//                // 1. Connect to the Modbus TCP server
//                InetAddress address = InetAddress.getByName(modbusHost);
//                connection = new TCPMasterConnection(address);
//                connection.setPort(port);
//                connection.connect();
//
//                // 2. Create a request to read the register at "1번 방"
//                int startAddress = 38; // 1번 방이 레지스터 0번에 해당한다고 가정
//                int quantity = 1; // 1개의 레지스터만 읽기
//                ReadMultipleRegistersRequest request = new ReadMultipleRegistersRequest(startAddress, quantity);
//                request.setUnitID(unitId);
//
//                // 3. Create and execute the transaction
//                transaction = new ModbusTCPTransaction(connection);
//                transaction.setRequest(request);
//                transaction.execute();
//
//                // 4. Process the response
//                ReadMultipleRegistersResponse response = (ReadMultipleRegistersResponse) transaction.getResponse();
//                System.out.println("Value in Register " + startAddress + ": " + response.getRegisterValue(0));
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                // Close the connection
//                if (connection != null && connection.isConnected()) {
//                    connection.close();
//                }
//            }
        TCPMasterConnection connection = null; // Modbus TCP connection
        ModbusTCPTransaction transaction = null; // Modbus TCP transaction
        int unitId = 1; // Modbus Slave Unit ID (1 by default)
        String modbusHost = "192.168.50.9"; // Modbus server IP
        int port = 502; // Modbus TCP port

        try {
            // 1. Connect to the Modbus TCP server
            InetAddress address = InetAddress.getByName(modbusHost);
            connection = new TCPMasterConnection(address);
            connection.setPort(port);
            connection.connect();

            // 2. Create a request to write a value to a single register
            int registerAddress = 1000; // PLC의 Modbus 레지스터 주소 (예: 1번 방이 레지스터 0번)
            int valueToWrite = 0; // PLC에 쓰고자 하는 값
            WriteSingleRegisterRequest request = new WriteSingleRegisterRequest(registerAddress, new SimpleRegister(valueToWrite));
            request.setUnitID(unitId); // Modbus Unit ID 설정

            // 3. Create and execute the transaction
            transaction = new ModbusTCPTransaction(connection);
            transaction.setRequest(request);
            transaction.execute();

            // 4. Log successful write
            System.out.println("Successfully wrote value " + valueToWrite + " to register " + registerAddress);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            if (connection != null && connection.isConnected()) {
                connection.close();
            }
        }
//        TCPMasterConnection connection = null; // Modbus TCP connection
//        ModbusTCPTransaction transaction = null; // Modbus TCP transaction
//        int unitId = 1; // Modbus Slave Unit ID
//        String modbusHost = "172.30.1.100"; // Modbus server IP
//        int port = 502; // Modbus TCP port
//
//        try {
//            // 1. Connect to the Modbus TCP server
//            InetAddress address = InetAddress.getByName(modbusHost);
//            connection = new TCPMasterConnection(address);
//            connection.setPort(port);
//            connection.connect();
//
//            // 2. Create a request to read Input Registers
//            int startAddress = 0; // Start address of Input Registers
//            int quantity = 5; // Number of registers to read
//            ReadInputRegistersRequest request = new ReadInputRegistersRequest(startAddress, quantity);
//            request.setUnitID(unitId);
//
//            // 3. Execute the transaction
//            transaction = new ModbusTCPTransaction(connection);
//            transaction.setRequest(request);
//            transaction.execute();
//
//            // 4. Process the response
//            ReadInputRegistersResponse response = (ReadInputRegistersResponse) transaction.getResponse();
//            for (int i = 0; i < response.getWordCount(); i++) {
//                System.out.println("Input Register " + (startAddress + i) + ": " + response.getRegisterValue(i));
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // Close the connection
//            if (connection != null && connection.isConnected()) {
//                connection.close();
//            }
//        }
//        TCPMasterConnection connection = null; // Modbus TCP connection
//        ModbusTCPTransaction transaction = null; // Modbus TCP transaction
//        int unitId = 1; // Modbus Slave Unit ID
//        String modbusHost = "172.30.1.100"; // Modbus server IP
//        int port = 502; // Modbus TCP port
//
//        try {
//            // 1. Connect to the Modbus TCP server
//            InetAddress address = InetAddress.getByName(modbusHost);
//            connection = new TCPMasterConnection(address);
//            connection.setPort(port);
//            connection.connect();
//
//            // 2. Create a request to write a single coil
//            int coilAddress = 0; // Coil address (Coil 1 -> Address 0)
//            boolean valueToWrite = true; // true for ON, false for OFF
//            WriteCoilRequest request = new WriteCoilRequest(coilAddress, valueToWrite);
//            request.setUnitID(unitId);
//
//            // 3. Execute the transaction
//            transaction = new ModbusTCPTransaction(connection);
//            transaction.setRequest(request);
//            transaction.execute();
//
//            // 4. Log the result
//            System.out.println("Successfully wrote value " + valueToWrite + " to coil " + coilAddress);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // Close the connection
//            if (connection != null && connection.isConnected()) {
//                connection.close();
//            }
//        }
//        TCPMasterConnection connection = null; // Modbus TCP connection
//        ModbusTCPTransaction transaction = null; // Modbus TCP transaction
//        int unitId = 1; // Modbus Slave Unit ID
//        String modbusHost = "172.30.1.100"; // Modbus server IP
//        int port = 502; // Modbus TCP port
//
//        try {
//            // 1. Connect to the Modbus TCP server
//            InetAddress address = InetAddress.getByName(modbusHost);
//            connection = new TCPMasterConnection(address);
//            connection.setPort(port);
//            connection.connect();
//
//            // 2. Create a request to read discrete inputs
//            int startAddress = 0; // Start address of discrete inputs
//            int quantity = 100; // Number of discrete inputs to read
//            ReadInputDiscretesRequest request = new ReadInputDiscretesRequest(startAddress, quantity);
//            request.setUnitID(unitId);
//
//            // 3. Execute the transaction
//            transaction = new ModbusTCPTransaction(connection);
//            transaction.setRequest(request);
//            transaction.execute();
//
//            // 4. Process the response
//            ReadInputDiscretesResponse response = (ReadInputDiscretesResponse) transaction.getResponse();
//            for (int i = 0; i < quantity; i++) {
//                boolean discreteStatus = response.getDiscreteStatus(i);
//                System.out.println("Discrete Input " + (startAddress + i) + ": " + discreteStatus);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // Close the connection
//            if (connection != null && connection.isConnected()) {
//                connection.close();
//            }
//        }
//        TCPMasterConnection connection = null; // Modbus TCP connection
//        ModbusTCPTransaction transaction = null; // Modbus TCP transaction
//        int unitId = 1; // Modbus Slave Unit ID
//        String modbusHost = "172.30.1.100"; // Modbus server IP
//        int port = 502; // Modbus TCP port
//
//        try {
//            // 1. Connect to the Modbus TCP server
//            InetAddress address = InetAddress.getByName(modbusHost);
//            connection = new TCPMasterConnection(address);
//            connection.setPort(port);
//            connection.connect();
//
//            // 2. Create a request to write a single coil
//            int coilAddress = 1; // Coil address (Coil 1 -> Address 0)
//            boolean valueToWrite = false; // true for ON, false for OFF
//            WriteCoilRequest request = new WriteCoilRequest(coilAddress, valueToWrite);
//            request.setUnitID(unitId);
//
//            // 3. Execute the transaction
//            transaction = new ModbusTCPTransaction(connection);
//            transaction.setRequest(request);
//            transaction.execute();
//
//            // 4. Log the result
//            System.out.println("Successfully wrote value " + valueToWrite + " to coil " + coilAddress);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // Close the connection
//            if (connection != null && connection.isConnected()) {
//                connection.close();
//            }
//        }
        };
    }
}
