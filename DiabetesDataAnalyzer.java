import java.util.ArrayList;
import java.util.List;

/**
 * HealthTech Data Analyzer
 * Analyzes diabetes patient data (glucose, insulin, lifestyle) to flag high-risk 
 * patients and provide data-driven healthcare solutions.
 * * Dataset reference: 1994 AAAI Spring Symposium on AI in Medicine.
 */
public class DiabetesDataAnalyzer {

    // Simulating a patient record based on the dataset structure
    static class PatientRecord {
        int patientId;
        double averageGlucose;
        double averageInsulin;
        boolean activeLifestyle;

        public PatientRecord(int patientId, double averageGlucose, double averageInsulin, boolean activeLifestyle) {
            this.patientId = patientId;
            this.averageGlucose = averageGlucose;
            this.averageInsulin = averageInsulin;
            this.activeLifestyle = activeLifestyle;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Initializing Diabetes Data Analyzer ---");
        
        // Simulating a subset of the 70 patient records from the AAAI dataset
        List<PatientRecord> patientData = loadPatientData();
        
        System.out.println("Analyzing data for " + patientData.size() + " patients...\n");
        
        int highRiskCount = 0;
        double totalGlucose = 0;

        for (PatientRecord patient : patientData) {
            totalGlucose += patient.averageGlucose;
            
            // Basic algorithm to flag high-risk patients
            if (patient.averageGlucose > 140.0 || (patient.averageGlucose > 120.0 && !patient.activeLifestyle)) {
                highRiskCount++;
                generatePatientSolution(patient);
            }
        }

        double cohortAverage = totalGlucose / patientData.size();
        
        System.out.println("\n--- Cohort Summary ---");
        System.out.println("Average Glucose Level: " + String.format("%.2f", cohortAverage) + " mg/dL");
        System.out.println("High-Risk Patients Identified: " + highRiskCount);
    }

    private static void generatePatientSolution(PatientRecord patient) {
        System.out.println("ALERT: Patient ID " + patient.patientId + " flagged as High-Risk.");
        System.out.print("Recommended Solution: ");
        
        if (!patient.activeLifestyle) {
            System.out.println("Enroll in a supervised exercise program to improve insulin sensitivity.");
        } else if (patient.averageInsulin < 15.0) {
            System.out.println("Review insulin dosage with endocrinologist; current levels may be insufficient.");
        } else {
            System.out.println("Implement continuous glucose monitoring (CGM) to track daily spikes.");
        }
    }

    private static List<PatientRecord> loadPatientData() {
        // Mock data representing the glucose, insulin, and lifestyle metrics
        List<PatientRecord> records = new ArrayList<>();
        records.add(new PatientRecord(101, 110.5, 20.2, true));
        records.add(new PatientRecord(102, 145.0, 12.5, false));
        records.add(new PatientRecord(103, 125.0, 18.0, false));
        records.add(new PatientRecord(104, 95.0, 25.0, true));
        records.add(new PatientRecord(105, 160.2, 14.1, true));
        return records;
    }
}
