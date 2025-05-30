import React, { useCallback, useEffect, useState } from 'react';
import {
	Checkbox,
	FormGroup,
	Card,
	CardBody,
	TextInput,
	Split,
	SplitItem,
	Button,
} from '@patternfly/react-core';
import { PlusCircleIcon, MinusCircleIcon } from '@patternfly/react-icons';
const Form__hiring_HRInterview: React.FC<any> = (props: any) => {
	const [formApi, setFormApi] = useState<any>();
	const [approve, set__approve] = useState<boolean>(false);
	const [candidate__email, set__candidate__email] = useState<string>('');
	const [candidate__experience, set__candidate__experience] =
		useState<number>();
	const [candidate__lastName, set__candidate__lastName] = useState<string>('');
	const [candidate__name, set__candidate__name] = useState<string>('');
	const [candidate__skills, set__candidate__skills] = useState<string[]>([]);
	const [offer__category, set__offer__category] = useState<string>('');
	const [offer__salary, set__offer__salary] = useState<number>();
	/* Utility function that fills the form with the data received from the kogito runtime */
	const setFormData = (data) => {
		if (!data) {
			return;
		}
		set__approve(data?.approve ?? false);
		set__candidate__email(data?.candidate?.email ?? '');
		set__candidate__experience(data?.candidate?.experience);
		set__candidate__lastName(data?.candidate?.lastName ?? '');
		set__candidate__name(data?.candidate?.name ?? '');
		set__candidate__skills(data?.candidate?.skills ?? []);
		set__offer__category(data?.offer?.category ?? '');
		set__offer__salary(data?.offer?.salary);
	};
	/* Utility function to generate the expected form output as a json object */
	const getFormData = useCallback(() => {
		const formData: any = {};
		formData.approve = approve;
		formData.offer = {};
		formData.offer.category = offer__category;
		formData.offer.salary = offer__salary;
		return formData;
	}, [approve, offer__category, offer__salary]);
	/* Utility function to validate the form on the 'beforeSubmit' Lifecycle Hook */
	const validateForm = useCallback(() => {}, []);
	/* Utility function to perform actions on the on the 'afterSubmit' Lifecycle Hook */
	const afterSubmit = useCallback((result) => {}, []);
	useEffect(() => {
		if (formApi) {
			/*
        Form Lifecycle Hook that will be executed before the form is submitted.
        Throwing an error will stop the form submit. Usually should be used to validate the form.
      */
			formApi.beforeSubmit = () => validateForm();
			/*
        Form Lifecycle Hook that will be executed after the form is submitted.
        It will receive a response object containing the `type` flag indicating if the submit has been successful and `info` with extra information about the submit result.
      */
			formApi.afterSubmit = (result) => afterSubmit(result);
			/* Generates the expected form output object to be posted */
			formApi.getFormData = () => getFormData();
		}
	}, [getFormData, validateForm, afterSubmit]);
	useEffect(() => {
		/*
      Call to the Kogito console form engine. It will establish the connection with the console embeding the form
      and return an instance of FormAPI that will allow hook custom code into the form lifecycle.
      The `window.Form.openForm` call expects an object with the following entries:
        - onOpen: Callback that will be called after the connection with the console is established. The callback
        will receive the following arguments:
          - data: the data to be bound into the form
          - ctx: info about the context where the form is being displayed. This will contain information such as the form JSON Schema, process/task, user...
    */
		const api = window.Form.openForm({
			onOpen: (data, context) => {
				setFormData(data);
			},
		});
		setFormApi(api);
	}, []);
	return (
		<div className={'pf-c-form'}>
			<FormGroup fieldId='uniforms-000q-0001'>
				<Checkbox
					isChecked={approve}
					isDisabled={false}
					id={'uniforms-000q-0001'}
					name={'approve'}
					label={'Approve'}
					onChange={set__approve}
				/>
			</FormGroup>
			<Card>
				<CardBody className='pf-c-form'>
					<label>
						<b>Candidate</b>
					</label>
					<FormGroup
						fieldId={'uniforms-000q-0004'}
						label={'Email'}
						isRequired={false}>
						<TextInput
							name={'candidate.email'}
							id={'uniforms-000q-0004'}
							isDisabled={true}
							placeholder={''}
							type={'text'}
							value={candidate__email}
							onChange={set__candidate__email}
						/>
					</FormGroup>
					<FormGroup
						fieldId={'uniforms-000q-0006'}
						label={'Experience'}
						isRequired={false}>
						<TextInput
							type={'number'}
							name={'candidate.experience'}
							isDisabled={true}
							id={'uniforms-000q-0006'}
							placeholder={''}
							step={1}
							value={candidate__experience}
							onChange={(newValue) =>
								set__candidate__experience(Number(newValue))
							}
						/>
					</FormGroup>
					<FormGroup
						fieldId={'uniforms-000q-0007'}
						label={'Last name'}
						isRequired={false}>
						<TextInput
							name={'candidate.lastName'}
							id={'uniforms-000q-0007'}
							isDisabled={true}
							placeholder={''}
							type={'text'}
							value={candidate__lastName}
							onChange={set__candidate__lastName}
						/>
					</FormGroup>
					<FormGroup
						fieldId={'uniforms-000q-0008'}
						label={'Name'}
						isRequired={false}>
						<TextInput
							name={'candidate.name'}
							id={'uniforms-000q-0008'}
							isDisabled={true}
							placeholder={''}
							type={'text'}
							value={candidate__name}
							onChange={set__candidate__name}
						/>
					</FormGroup>
					<div>
						<Split hasGutter>
							<SplitItem>
								{'Skills' && (
									<label className={'pf-c-form__label'}>
										<span className={'pf-c-form__label-text'}>Skills</span>
									</label>
								)}
							</SplitItem>
							<SplitItem isFilled />
							<SplitItem>
								<Button
									name='$'
									variant='plain'
									style={{ paddingLeft: '0', paddingRight: '0' }}
									disabled={true}
									onClick={() => {
										!true &&
											set__candidate__skills(
												(candidate__skills ?? []).concat([''])
											);
									}}>
									<PlusCircleIcon color='#0088ce' />
								</Button>
							</SplitItem>
						</Split>
						<div>
							{candidate__skills?.map((_, itemIndex) => (
								<div
									key={itemIndex}
									style={{
										marginBottom: '1rem',
										display: 'flex',
										justifyContent: 'space-between',
									}}>
									<div style={{ width: '100%', marginRight: '10px' }}>
										<FormGroup
											fieldId={'uniforms-000q-000b'}
											label={''}
											isRequired={false}>
											<TextInput
												name={`candidate__skills.${itemIndex}`}
												id={'uniforms-000q-000b'}
												isDisabled={true}
												placeholder={''}
												type={'text'}
												value={candidate__skills?.[itemIndex]}
												onChange={(newValue) => {
													set__candidate__skills((s) => {
														const newState = [...s];
														newState[itemIndex] = newValue;
														return newState;
													});
												}}
											/>
										</FormGroup>
									</div>
									<div>
										<Button
											disabled={true}
											variant='plain'
											style={{ paddingLeft: '0', paddingRight: '0' }}
											onClick={() => {
												const value = [...candidate__skills];
												value.splice(itemIndex, 1);
												!true && set__candidate__skills(value);
											}}>
											<MinusCircleIcon color='#cc0000' />
										</Button>
									</div>
								</div>
							))}
						</div>
					</div>
				</CardBody>
			</Card>
			<Card>
				<CardBody className='pf-c-form'>
					<label>
						<b>Offer</b>
					</label>
					<FormGroup
						fieldId={'uniforms-000q-000e'}
						label={'Category'}
						isRequired={false}>
						<TextInput
							name={'offer.category'}
							id={'uniforms-000q-000e'}
							isDisabled={false}
							placeholder={''}
							type={'text'}
							value={offer__category}
							onChange={set__offer__category}
						/>
					</FormGroup>
					<FormGroup
						fieldId={'uniforms-000q-000g'}
						label={'Salary'}
						isRequired={false}>
						<TextInput
							type={'number'}
							name={'offer.salary'}
							isDisabled={false}
							id={'uniforms-000q-000g'}
							placeholder={''}
							step={1}
							value={offer__salary}
							onChange={(newValue) => set__offer__salary(Number(newValue))}
						/>
					</FormGroup>
				</CardBody>
			</Card>
		</div>
	);
};
export default Form__hiring_HRInterview;
