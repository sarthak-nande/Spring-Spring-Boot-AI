package com.ragimplementation.implementrag.rag;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;


@Component
public class RandomDataLoaderForRag {
	
	private final VectorStore vectorStore;
	
	@Autowired
	public RandomDataLoaderForRag(VectorStore vectorStore) {
		this.vectorStore = vectorStore;
	}
	
	@PostConstruct
	public void loadTheListOfdataIntoVectorStore() {
		List<String> data = new ArrayList<>();

        // === ONLINE REGISTRATION & ACCOUNT INITIALIZATION ===
        data.add("The official portal for all Indian passport services is the Passport Seva Portal managed by the Ministry of External Affairs at passportindia.gov.in.");
        data.add("Applicants must register as a new user by providing a functional email ID, name, date of birth, and choosing their nearest Regional Passport Office.");
        data.add("An account activation link is sent to the user's registered email address, which remains valid for a limited period to complete the signup process.");
        data.add("The Passport Seva portal forces users to change their account login passwords every 3 months for security and data privacy reasons.");
        data.add("Users can alternative handle their entire application process through mobile devices using the official mPassport Seva App available on iOS and Android.");
        data.add("While registering an account, the user must select their Regional Passport Office based on where they are currently residing, not their permanent address.");
        data.add("If an application form is filled online but the applicant does not visit a Passport Seva Kendra within 90 days, the form expires and must be resubmitted.");
        data.add("Logging into the portal provides a central dashboard showing the real-time status of all submitted, saved, or partially filed application instances.");
        data.add("The Passport Seva Portal restricts concurrent active applications under a single user ID to prevent fraud and spamming on the government servers.");
        data.add("When initiating a request, the user must explicitly choose between an Ordinary Passport, a Diplomatic Passport, or an Official Passport.");

        // === APPLICATION CHOICES & PASS BOOKLET TYPE ===
        data.add("An ordinary Indian citizen passport features a Deep Blue cover, while official passports are white and diplomatic passports are maroon.");
        data.add("When filling the form, an applicant must select whether they require a Fresh Passport or a Re-issue of an existing passport booklet.");
        data.add("Re-issue of an Indian passport must be selected if the current booklet has expired, is expiring within one year, or has run out of blank pages.");
        data.add("Applicants can choose between a standard 36-page booklet and an exhaustive 60-page jumbo booklet based on their expected international travel frequency.");
        data.add("For adult applicants, an ordinary Indian passport is issued with a standard validity period of 10 years from the date of approval.");
        data.add("Minors between the ages of 15 and 18 can opt for either a 10-year validity passport or a passport valid only until they attain the age of 18.");
        data.add("Passports for children and minors below 15 years of age are strictly restricted to a maximum validity period of 5 years or until they turn 18.");
        data.add("The base government application processing fee for a fresh adult 10-year validity passport with 36 pages is 1,500 Indian Rupees.");
        data.add("An adult applicant selecting a 60-page jumbo booklet under the Normal application category is charged a base fee of 2,000 Indian Rupees.");
        data.add("For minor applicants below 18 years under the normal scheme, the passport application fee is 1,000 Indian Rupees for a 36-page booklet.");

        // === TATKAAL SCHEME RULES ===
        data.add("The Tatkaal scheme is designed for emergency passport processing, allowing passports to be printed and dispatched within 1 to 3 days.");
        data.add("An additional premium urgency fee of 2,000 Indian Rupees is charged on top of the base passport fee for all Tatkaal scheme applications.");
        data.add("Booking an appointment under the Tatkaal scheme requires the applicant to submit an explicit Tatkaal Undertaking declaration form.");
        data.add("Not all citizens are eligible for Tatkaal; major name changes, lost passports, or complex family changes cannot be processed under the urgent scheme.");
        data.add("Tatkaal applications usually bypass the pre-police verification phase, initiating passport printing immediately on a Post-Police verification basis.");
        data.add("Applicants trying for Tatkaal must provide at least three specific identity documents out of an approved list of government credentials.");
        data.add("A regional passport officer retains the final discretionary power to convert a Tatkaal application back to Normal if data discrepancies are found.");
        data.add("Tatkaal appointments are highly competitive, and the portal opens regional quotas daily at specific region-wise opening times.");
        data.add("If a Tatkaal passport is granted, it is printed with an embedded electronic RFID chip, just like a standard regular category passport.");
        data.add("Payment for Tatkaal passports must be completed online via electronic modes before an appointment slot can be locked on the portal.");

        // === FEES, PAYMENTS, & APPOINTMENT SCHEDULING ===
        data.add("Prior online payment of the applicable passport service fee is completely mandatory before booking an appointment slot at any center.");
        data.add("The portal accepts multiple online payment methods including internet banking, credit cards, debit cards, UPI, and State Bank of India challans.");
        data.add("Once an application fee is paid online, it remains valid for one full year, allowing the user to schedule appointments during that timeframe.");
        data.add("Applicants are permitted to reschedule or cancel an already booked Passport Seva Kendra appointment a maximum of three times within the year.");
        data.add("If an applicant misses their scheduled appointment three times, the system forfeits the application fee, requiring a fresh payment.");
        data.add("The online system automatically presents the next available calendar dates and open timeslots for all nearby centers once payment is cleared.");
        data.add("After a successful booking, the system displays an Appointment Confirmation screen detailing the target center, batch time, and token info.");
        data.add("An official SMS received on the applicant's registered mobile phone containing appointment details is accepted as valid proof of entry at the center.");
        data.add("Carrying a physical printout of the online Application Reference Number receipt is no longer mandatory if the SMS confirmation is present.");
        data.add("The system allows users to check live appointment slot availability charts across any district in India without completing a transaction.");

        // === DOCUMENTS AND PROOFS (IDENTITY, AGE, ADDRESS) ===
        data.add("An Aadhaar card or e-Aadhaar is widely accepted as both a valid proof of identity and a valid proof of current residential address.");
        data.add("A permanent account number card issued by the Income Tax Department is a highly recognized document for establishing identity.");
        data.add("A valid Indian driving license or an official Voter ID card can be used to satisfy identity and address criteria simultaneously.");
        data.add("For individuals born on or after October 1, 1989, a formal birth certificate issued by a municipal authority is the premier proof of age.");
        data.add("A school leaving certificate or a 10th-grade matriculation marksheet showing the date of birth is acceptable proof of age for older applicants.");
        data.add("Current residential address proof can be validated using utility bills like electricity, telephone, water, or piped gas bills in the applicant's name.");
        data.add("A running bank account statement showing an attested photograph of the applicant from a scheduled public bank is a valid address proof.");
        data.add("Registered rental agreements or formal income tax assessment orders can be legally used to establish an applicant's current address.");
        data.add("If an applicant uses DigiLocker to link their documents digitally, it speeds up the processing time at the verification windows.");
        data.add("Even when fetching credentials via DigiLocker, applicants must carry their original physical documents to the center for verification.");

        // === SPECIAL CATEGORIES (MINORS, MARRIED, NON-ECR) ===
        data.add("For minor applicants below 4 years of age, parents must bring a recent passport-sized photograph with a clear white background to the center.");
        data.add("A newborn baby's passport application mandates the submission of a birth certificate along with self-attested copies of both parents' passports.");
        data.add("Annexure D is a mandatory parental consent declaration form that must be signed by both parents to issue a passport to a minor child.");
        data.add("If one parent cannot provide consent due to separation or absence, Annexure C must be executed by the applying parent for a minor passport.");
        data.add("Police verification for a newborn minor is completely waived if both parents hold valid passports with their spouse's names cross-endorsed.");
        data.add("For infants who cannot write, a dark ink thumb impression is captured on the form: left thumb for boys and right thumb for girls.");
        data.add("Non-ECR status stands for Emigration Check Not Required, which is automatically granted to anyone who has passed the 10th standard exam.");
        data.add("Applicants without a 10th-grade passing certificate are designated as ECR and require clearance before traveling to specific countries for work.");
        data.add("Married applicants are no longer legally required to produce a marriage certificate or execute a joint affidavit to append a spouse's name.");
        data.add("Divorced or separated applicants are not required to provide a spouse's name or submit a divorce decree unless there is a critical name change.");

        // === THE THREE-COUNTER PSK WORKFLOW (COUNTERS A, B, C) ===
        data.add("Upon arrival at a Passport Seva Kendra, the applicant undergoes a strict security screening before entry is allowed into the main hall.");
        data.add("At the pre-processing desk, an official checks the basic appointment time and prints a physical Token Number for tracking inside.");
        data.add("The waiting lounge contains automated LCD displays showing individual token numbers alongside their assigned service counter coordinates.");
        data.add("Counter A is operated by a Citizen Service Executive who scans all supporting documents and uploads them into the secure MEA core database.");
        data.add("At Counter A, the executive captures the applicant’s biometrics, which includes digital fingerprints of all ten fingers and a live webcam photograph.");
        data.add("Personal particulars uploaded at Counter A are printed onto a receipt for the applicant to verify, sign, and return for digital archiving.");
        data.add("Counter B is managed by a government Verification Officer who cross-checks all digital scans against the applicant's original documents.");
        data.add("The Verification Officer at Counter B ensures the authenticity of certificates and marks the documents as verified in the internal system.");
        data.add("Counter C is controlled by a senior Granting Officer who evaluates the overall application file and makes the final decision on passport issuance.");
        data.add("The Granting Officer at Counter C officially changes the application status to Granted, Pending, or Review based on document integrity.");

        // === CENTER LOGISTICS (PSK & POPSK) ===
        data.add("A Passport Seva Kendra is a state-of-the-art facility optimized for high-volume identity validation and document processing workflows.");
        data.add("To expand rural reach, the Ministry of External Affairs collaborates with the Department of Posts to establish Post Office Passport Seva Kendras.");
        data.add("A Post Office Passport Seva Kendra provides identical document verification and biometric services locally, saving long-distance travel.");
        data.add("An applicant can freely book an appointment at any convenient Passport Seva Kendra across India, regardless of their native state.");
        data.add("Regional Passport Offices operate as the administrative headquarters over local centers, handling complex appeals and special grievances.");
        data.add("Before leaving the center, the applicant must stop at the Exit Gate to collect a printed, physical Acknowledgement Letter.");
        data.add("The Acknowledgement Letter contains the final processing status of the application and a unique tracking barcode for future reference.");
        data.add("Inside the processing zones of a Passport Seva Kendra, the use of private mobile phones, cameras, or audio recording devices is strictly prohibited.");
        data.add("Special lanes and priority tokens are provided at all centers to accommodate senior citizens, pregnant women, and physically challenged individuals.");
        data.add("If an application is marked for Review at Counter C, the applicant is instructed to visit the main Regional Passport Office for a meeting.");

        // === POLICE VERIFICATION PROCESS ===
        data.add("Police verification is a mandatory background investigation conducted to verify the identity, nationality, and criminal history of the applicant.");
        data.add("Under the Pre-Police Verification model, the passport is only printed and dispatched after a clear report is uploaded by the police station.");
        data.add("Under the Post-Police Verification model, the passport is printed immediately, and the police verification is conducted asynchronously later.");
        data.add("The Ministry of External Affairs utilizes the mPassport Police App, allowing field officers to capture and submit digital verification reports on-site.");
        data.add("The digital mPassport Police App eliminates physical paper routing, reducing the background check duration from weeks to just a few days.");
        data.add("A local police official visits the current residential address provided by the applicant to confirm their actual duration of stay.");
        data.add("During the verification visit, the applicant should present photocopies of their address proofs and have two local neighbors sign as witnesses.");
        data.add("Automated SMS notifications are triggered to the applicant when their file moves from the Passport Office to the local Police Superintendent's database.");
        data.add("An adverse police report due to hidden criminal cases or an incorrect address can lead to the immediate impounding of a passport.");
        data.add("If an applicant has resided at multiple addresses over the past 12 months, separate verification requests are triggered for each location.");

        // === E-PASSPORTS, PRINTING, DISPATCH, & TRACKING ===
        data.add("All new passports issued by the Government of India feature an embedded microprocessor electronic chip containing biometric data.");
        data.add("The e-passport upgrade complies with International Civil Aviation Organization standards, offering enhanced security against cloning.");
        data.add("The secure RFID chip in the e-passport holds the applicant's digital facial print, fingerprints, and personal demographic profiles.");
        data.add("Once an application is marked as Granted and passes verification, automated high-speed printing engines create the physical booklet.");
        data.add("Finished passport booklets are securely packaged and handed over to India Post for rapid delivery to the citizen's current address.");
        data.add("Passports are strictly dispatched via India Post Speed Post service to ensure trackable and highly secure transit logistics.");
        data.add("The Passport Seva portal updates the applicant's dashboard with a unique 13-digit Speed Post tracking number upon package dispatch.");
        data.add("According to security protocols, a Speed Post delivery agent can only deliver the passport package directly to the actual holder or an immediate family member.");
        data.add("If the house is locked or the applicant is unreachable after multiple attempts, the post office returns the passport package to the originating RPO.");
        data.add("Citizens can track live application progress using the portal, the mPassport App, or by dialing the national call center at 1800-258-1800.");
        
        List<Document> documents = data.stream().map(Document::new).collect(Collectors.toList());
        vectorStore.add(documents);
	}

}
